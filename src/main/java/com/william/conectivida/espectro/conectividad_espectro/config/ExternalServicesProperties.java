package com.william.conectivida.espectro.conectividad_espectro.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app")
public class ExternalServicesProperties {
    private Map<String, ServiceConfig> externalServices = new HashMap<>();

    @Getter
    @Setter
    public static class ServiceConfig {
        private String baseUrl;
        private String apiKey;
        private int timeoutMs = 5000;
    }
}
