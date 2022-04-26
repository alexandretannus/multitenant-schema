package com.example.multitenancy.schema.config.datasource;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConfigurationProperties("esportes")
public class DataSourceProperties {
    private Map<Object, Object> datasources = new LinkedHashMap<>();

    public Map<Object, Object> getDatasources() {
        log.info("get datasources");
        return datasources;
    }

    public void setDatasources(Map<String, Map<String, String>> datasources) {
        datasources.forEach((key, value) -> this.datasources.put(key, convert(value)));
    }

    public DataSource convert(Map<String, String> source) {
        log.info("convert datasources");
        return DataSourceBuilder.create().url(source.get("url")).username(source.get("username"))
                .password(source.get("password")).driverClassName(source.get("driverClassName")).build();
    }

}
