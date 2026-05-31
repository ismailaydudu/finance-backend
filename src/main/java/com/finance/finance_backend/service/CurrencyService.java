package com.finance.finance_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class CurrencyService {

    public Map<String, Object> canliKurGetir() {
        // Ücretsiz ve kayıt gerektirmeyen canlı döviz API adresi (Temel baz: USD)
        String url = "https://open.er-api.com/v6/latest/USD";
        
        // Spring Boot'un dış sitelere istek atan sihirli aracı
        RestTemplate restTemplate = new RestTemplate();

        // URL'ye git, gelen devasa JSON'u otomatik olarak Java Sözlüğüne (Map) çevir
        @SuppressWarnings("unchecked")
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        
        return response;
    }
}