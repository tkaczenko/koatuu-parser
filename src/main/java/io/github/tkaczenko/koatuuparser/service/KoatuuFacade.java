package io.github.tkaczenko.koatuuparser.service;

import io.github.tkaczenko.koatuuparser.model.local.KoatuuProperties;
import io.github.tkaczenko.koatuuparser.model.local.LocationDTO;
import io.github.tkaczenko.koatuuparser.service.local.KoatuuLoader;
import io.github.tkaczenko.koatuuparser.service.local.KoatuuParser;
import io.github.tkaczenko.koatuuparser.service.local.LocationWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Andrii Tkachenko
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class KoatuuFacade {
    private final KoatuuProperties properties;

    private final KoatuuLoader koatuuLoader;
    private final KoatuuParser koatuuParser;
    private final LocationWriter locationWriter;

    public void parse(String url, String destination, String fileName) throws IOException {
        String filePath = "%s/%s";
        url = textOrDefault(url, properties.getDefaultUrl());
        destination = textOrDefault(destination, properties.getDefaultPath());
        fileName = textOrDefault(fileName, properties.getDefaultFileName());

        koatuuLoader.downloadAndExtractZip(url, destination);
        log.info("Downloaded and extracted zip to {}", destination);

        String fileToParse = String.format(filePath, destination, fileName);
        log.info("Trying to parse file at {}", fileToParse);
        long startTime = System.currentTimeMillis();
        List<LocationDTO> parsed = koatuuParser.parse(fileToParse);
        log.info("Parsed {} locations from file at {}: spentTime={}", parsed.size(), fileToParse, System.currentTimeMillis() - startTime);

        log.info("Trying to generate sql script");
        String savedScript = locationWriter.write(destination, parsed);
        log.info("Generated script for inserting locations with KOATUU at {}: spentTime={}", savedScript, System.currentTimeMillis() - startTime);
    }

    private String textOrDefault(String text, String defaultText) {
        return Optional.ofNullable(text)
                .orElse(defaultText);
    }
}
