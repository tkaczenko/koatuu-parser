package io.github.tkaczenko.koatuuparser.service.local;

import io.github.tkaczenko.koatuuparser.model.Koatuu;
import io.github.tkaczenko.koatuuparser.model.KoatuuStructure;
import io.github.tkaczenko.koatuuparser.model.KoatuuValues;
import io.github.tkaczenko.koatuuparser.model.local.LocationDTO;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Andrii Tkachenko
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class KoatuuParser {
    private static final List<Integer> SETTLEMENT_CODES = Arrays.asList(
            KoatuuValues.Level2Type.DISTRICT, KoatuuValues.Level2Type.DISTRICT_CITY
    );

    private Map<String, String> regions = new HashMap<>();
    private Map<String, String> districts = new HashMap<>();
    private Map<String, Settlement> settlements = new HashMap<>();

    @Builder
    @Data
    private static class Settlement implements Serializable {
        private String settlement;
        private String locationType;
        private String regionCode;
        private String districtCode;
    }

    public List<LocationDTO> parse(String filePath) throws IOException {
        try (var in = new FileInputStream(new File(filePath))) {
            var wb = new HSSFWorkbook(in);
            var sheet = wb.getSheetAt(0);
            StreamSupport.stream(Spliterators.spliteratorUnknownSize(sheet.iterator(), Spliterator.ORDERED), false)
                    .skip(1)
                    .forEach(row -> processKoatuu(parseRowToObject(row)));
            return settlements.entrySet().stream()
                    .map(e -> LocationDTO.builder()
                            .koatuu(e.getKey())
                            .region(regions.get(e.getValue().getRegionCode()))
                            .district(districts.get(e.getValue().getDistrictCode()))
                            .settlement(e.getValue().getSettlement())
                            .locationType(e.getValue().getLocationType())
                            .build())
                    .collect(Collectors.toList());
        }
    }

    private void processKoatuu(Koatuu koatuu) {
        KoatuuStructure koatuuStructure = koatuu.getStructure();

        int level2Type = koatuuStructure.getLevel2Type();
        String level2Code = koatuuStructure.getLevel2Code();
        int level3Type = koatuuStructure.getLevel3Type();
        boolean isLevel3City = level2Type == KoatuuValues.Level2Type.DISTRICT_CITY
                && !"00".equals(level2Code)
                && level3Type == 0;
        boolean isLevel3Settlement = SETTLEMENT_CODES.contains(level2Type)
                && level3Type != 0
                && !"00".contains(koatuuStructure.getLevel3Code())
                && !"00".contains(koatuuStructure.getLevel4Code());

        String regionCode = koatuuStructure.getLevel1Code();
        String districtCode = regionCode + koatuuStructure.getLevel2Code();
        String koatuuName = koatuu.getName();

        if (level2Type == 0) {
            String name = koatuuName.split("/")[0].toLowerCase().replace("'", "\\'");
            regions.put(regionCode, capitalizeFirstLetter(name));
        } else if (level2Type == KoatuuValues.Level2Type.DISTRICT && !"00".equals(level2Code) && level3Type == 0) {
            String name = koatuuName.split("/")[0].toLowerCase().replace("'", "\\'");
            districts.put(districtCode, capitalizeFirstLetter(name));
        } else if (isLevel3City || isLevel3Settlement) {
            String name = koatuuName.toLowerCase().replace("'", "\\'");
            settlements.put(koatuu.getKoatuu(), Settlement.builder()
                    .settlement(capitalizeFirstLetter(name))
                    .locationType(koatuu.getCategory())
                    .regionCode(regionCode)
                    .districtCode(districtCode)
                    .build());
        }
    }

    private Koatuu parseRowToObject(Row row) {
        String koatuuObjectCode = String.format("%010d", Long.valueOf(row.getCell(0).getStringCellValue()));
        return Koatuu.builder()
                .koatuu(koatuuObjectCode)
                .category(row.getCell(1).getStringCellValue().toLowerCase())
                .name(row.getCell(2).getStringCellValue())
                .structure(KoatuuStructure.builder()
                        .level1Code(koatuuObjectCode.substring(0, 2))
                        .level2Type(Character.getNumericValue(koatuuObjectCode.charAt(2)))
                        .level2Code(koatuuObjectCode.substring(3, 5))
                        .level3Type(Character.getNumericValue(koatuuObjectCode.charAt(5)))
                        .level3Code(koatuuObjectCode.substring(6, 8))
                        .level4Code(koatuuObjectCode.substring(8, koatuuObjectCode.length() - 1))
                        .build())
                .build();
    }

    private String capitalizeFirstLetter(String text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
}
