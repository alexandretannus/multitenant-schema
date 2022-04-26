package com.example.multitenancy.schema.config.datasource;

import com.example.multitenancy.schema.config.tenants.TenantStorage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Slf4j
public class TenantRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("Determine Current Lookup Key");
        return TenantStorage.getTenantId();
    }

}
