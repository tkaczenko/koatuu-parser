package io.github.tkaczenko.koatuuparser.service.local;

import io.github.tkaczenko.koatuuparser.entity.tables.Location;
import io.github.tkaczenko.koatuuparser.model.local.LocationDTO;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Andrii Tkachenko
 */
@RequiredArgsConstructor
@Service
public class LocationWriter {
    private final DSLContext dsl;

    public String write(String destination, List<LocationDTO> locations) throws IOException {
        String filePath = "%s/%s";
        String scriptPath = String.format(filePath, destination, "locations.sql");

        String script = IntStream.range(0, locations.size())
                .mapToObj(i -> {
                    LocationDTO locationDTO = locations.get(i);
                    Location location = Location.LOCATION;
                    return dsl.renderInlined(
                            dsl.insertInto(location)
                                    .set(location.ID, Long.valueOf(i))
                                    .set(location.KOATUU, locationDTO.getKoatuu())
                                    .set(location.DISTRICT, locationDTO.getDistrict())
                                    .set(location.REGION, locationDTO.getRegion())
                                    .set(location.SETTLEMENT, locationDTO.getSettlement())
                                    .set(location.LOCATION_TYPE, locationDTO.getLocationType())
                    );
                })
                .collect(Collectors.joining(";\n"));
        Files.writeString(Paths.get(scriptPath), script, StandardCharsets.UTF_8);
        return scriptPath;
    }
}
