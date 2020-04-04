package io.github.tkaczenko.koatuuparser.configuration;

import io.github.tkaczenko.koatuuparser.model.local.KoatuuProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Andrii Tkachenko
 */
@Configuration
public class KoatuuParserConfig {
    @Bean
    @ConfigurationProperties(prefix = "koatuu")
    public KoatuuProperties koatuuImporterProperties() {
        return new KoatuuProperties();
    }
}
