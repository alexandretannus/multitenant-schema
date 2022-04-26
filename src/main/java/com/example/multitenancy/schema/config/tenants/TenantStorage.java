package com.example.multitenancy.schema.config.tenants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TenantStorage {

    private static ThreadLocal<String> tenantAtual = new ThreadLocal<>();

    public static String getTenantId() {
        log.info("get tenant id");
        return tenantAtual.get();
    }

    public static void setTenantId(String tenantId) {
        log.info("set tenant id");
        tenantAtual.set(tenantId);
    }
}