package com.comtrade360.assignment.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Configuration class for defining data source
 */
@Configuration
public class DataSourceConfiguration {

    //creating bean for dataSource object
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public HikariDataSource hikariDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
