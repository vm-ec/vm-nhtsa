package com.vm.ec.nhtsa.service;

import com.vm.ec.nhtsa.constants.NhtsaApiConstants;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ExchangeStrategies;

@Service
public class NhtsaService {

    private final WebClient webClient;

    public NhtsaService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl(NhtsaApiConstants.BASE_API_URL)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs()
                                .maxInMemorySize(10 * 1024 * 1024)) // Set buffer size to 10MB
                        .build())
                .build();
    }

    public String fetchAllMakes() {
        return webClient.get()
                .uri(NhtsaApiConstants.GET_ALL_MAKES_URL)
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Blocking for simplicity; avoid in reactive applications
    }

    public String fetchAllManufacturers() {
        return webClient.get()
                .uri(NhtsaApiConstants.GET_ALL_MANUFACTURERS_URL)
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Blocking for simplicity; avoid in reactive applications
    }

    public String fetchWMIsForManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.isEmpty()) {
            throw new IllegalArgumentException("Manufacturer parameter is required");
        }

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(NhtsaApiConstants.GET_WMIS_FOR_MANUFACTURER_URL + "/" + manufacturer)
                        .queryParam("format", "json")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Blocking for simplicity; avoid in reactive applications
    }

    public String fetchMakesForVehicle() {
        return webClient.get()
                .uri(NhtsaApiConstants.GET_MAKES_FOR_VEHICLE_URL)
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Blocking for simplicity; avoid in reactive applications
    }
}