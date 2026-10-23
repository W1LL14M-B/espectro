package com.william.conectivida.espectro.conectividad_espectro.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import com.william.conectivida.espectro.conectividad_espectro.config.ExternalServicesProperties;
import com.william.conectivida.espectro.conectividad_espectro.config.RestClientConfig;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component
@RequiredArgsConstructor
public class ExternalClient {

    private final ExternalServicesProperties properties;
    private final RestClientConfig restClientConfig;

    @Retry(name = "externo")
    @CircuitBreaker(name = "externo", fallbackMethod = "fallback")
    public <T> T get(String serviceName, String path, ParameterizedTypeReference<T> type) {
        var cfg = properties.getExternalServices().get(serviceName);
        if (cfg == null) throw new IllegalArgumentException("Servicio no configurado: " + serviceName);

        RestClient client = restClientConfig.createClient(cfg.getBaseUrl(), cfg.getTimeoutMs());
        log.info("-> Llamando externo [{}] {}{}", serviceName, cfg.getBaseUrl(), path);

        return client.get().uri(path).retrieve().body(type);
    }

    public <T> T fallback(String serviceName, String path, ParameterizedTypeReference<T> type, Throwable ex) {
        log.error("Fallo externo {}: {}", serviceName, ex.getMessage());
        throw new RuntimeException("El servicio externo " + serviceName + " no responde. Intenta mas tarde.");
    }
}