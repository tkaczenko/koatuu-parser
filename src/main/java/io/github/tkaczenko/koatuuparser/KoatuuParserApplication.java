package io.github.tkaczenko.koatuuparser;

import io.github.tkaczenko.koatuuparser.service.KoatuuImporterFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Andrii Tkachenko
 */
@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class KoatuuParserApplication {
    private final KoatuuImporterFacade koatuuImporterFacade;

    public static void main(String[] args) {
        SpringApplication.run(KoatuuParserApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup() {
        return args -> {
            String destination = args.length >= 1 ? args[0] : null;
            String url = args.length >= 2 ? args[1] : null;
            String fileName = args.length >= 3 ? args[2] : null;
            koatuuImporterFacade.parse(url, destination, fileName);
        };
    }
}
