package com.github.vp.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * Created by vimalpar on 08/04/17.
 */
@Configuration
@EnableAutoConfiguration
@ConditionalOnProperty(name = "inmemory.batch.repository", havingValue = "false")
public class DatabasePersistenceBatchConfiguration {

    @Bean
    @ConfigurationPropertiesBinding
    @ConfigurationProperties(prefix = "database.batch")
    public SimpleDriverDataSource dataSource() {
        return new SimpleDriverDataSource();
    }
}
