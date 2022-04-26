package com.example.multitenancy.schema.config.tenants;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Slf4j
@Component
public class TenantInterceptor implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest request) throws Exception {
        log.info("tenant interceptor pre handle");
        String serverName = ((ServletWebRequest) request)
                .getRequest()
                .getRequestURL()
                .toString();
        String tenantId = serverName
                .substring(serverName.indexOf(":") + 3, serverName.indexOf("."));
        System.out.println("\n------\n");
        System.out.println(tenantId);
        System.out.println("\n------\n");

        TenantStorage.setTenantId(tenantId);
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        // TODO Auto-generated method stub

    }

}
