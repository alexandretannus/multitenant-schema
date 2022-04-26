package com.example.multitenancy.schema.config.datasource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class DataSourceConfiguration {

    private final DataSourceProperties properties;

    public DataSourceConfiguration(DataSourceProperties properties) {
        this.properties = properties;
    }

    @Lazy
    @Bean
    public DataSource dataSource() {
        log.info("data source config");

        TenantRoutingDataSource customDataSource = new TenantRoutingDataSource();

        customDataSource.setTargetDataSources(properties.getDatasources());

        return customDataSource;
    }

    @PostConstruct
    public void migrate() {
        log.info("flyway");
        for (Object dataSource : properties.getDatasources().values()) {
            DataSource source = (DataSource) dataSource;
            Flyway flyway = Flyway.configure().dataSource(source).load();
            flyway.migrate();
        }
    }

}
