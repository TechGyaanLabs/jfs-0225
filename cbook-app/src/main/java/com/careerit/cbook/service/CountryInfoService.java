package com.careerit.cbook.service;

import com.careerit.cbook.domain.CountryInfo;
import com.careerit.cbook.dto.CountryInfoDto;
import com.careerit.cbook.repo.CountryInfoRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class CountryInfoService {

    private static final String API_URL = "https://restcountries.com/v3.1/all";

    @Autowired
    private CountryInfoRepo countryInfoRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    public List<CountryInfoDto> loadLatestData(boolean force) {
        if(force) {
            List<CountryInfoDto> countries = loadAndGetCountryInfo();
            log.info("Total {} countries are {}", countries.size(), countries.isEmpty() ? "found" : "saved");
            return countries;
        }else{
            List<CountryInfo> countries = countryInfoRepo.findAll();
            if(countries.isEmpty()) {
                log.info("No data found in DB, loading latest data from API");
                return loadAndGetCountryInfo();
            } else {
                log.info("Total {} countries are found in DB", countries.size());
            }
            return countries.stream()
                    .map(country -> objectMapper.convertValue(country, CountryInfoDto.class))
                    .toList();
        }
    }

    private List<CountryInfoDto> loadAndGetCountryInfo() {
        try {
            ResponseEntity<List> response = restTemplate.getForEntity(API_URL, List.class);

            if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
                log.warn("Failed to fetch data from API");
                return List.of();
            }

            List<CountryInfoDto> countryInfoDtos = response.getBody().stream()
                    .map(this::mapToCountryInfoDto)
                    .toList();

            if (countryInfoDtos.isEmpty()) {
                return List.of();
            }

            // Convert and save to database
            List<CountryInfo> countryInfos = countryInfoDtos.stream()
                    .map(dto -> objectMapper.convertValue(dto, CountryInfo.class))
                    .toList();

            countryInfoRepo.deleteAll();
            List<CountryInfo> savedCountries = countryInfoRepo.saveAll(countryInfos);

            return savedCountries.stream()
                    .map(country -> objectMapper.convertValue(country, CountryInfoDto.class))
                    .toList();

        } catch (Exception e) {
            log.error("Error loading country data: {}", e.getMessage());
            return List.of();
        }
    }

    private CountryInfoDto mapToCountryInfoDto(Object obj) {
        try {
            Map<String, Object> countryInfo = (Map<String, Object>) obj;
            Map<String, Object> name = (Map<String, Object>) countryInfo.get("name");
            Map<String, Object> flags = (Map<String, Object>) countryInfo.get("flags");

            return CountryInfoDto.builder()
                    .commonName(getString(name, "common"))
                    .officialName(getString(name, "official"))
                    .capital((List<String>) countryInfo.get("capital"))
                    .languages((Map<String, String>) countryInfo.get("languages"))
                    .region(getString(countryInfo, "region"))
                    .ccn3(getString(countryInfo, "ccn3"))
                    .population(getDouble(countryInfo, "population"))
                    .area(getDouble(countryInfo, "area"))
                    .flagSvg(getString(flags, "svg"))
                    .build();
        } catch (Exception e) {
            log.error("Error mapping country data: {}", e.getMessage());
            return null;
        }
    }

    private String getString(Map<String, Object> map, String key) {
        return Optional.ofNullable(map.get(key))
                .map(Object::toString)
                .orElse("");
    }

    private double getDouble(Map<String, Object> map, String key) {
        return Optional.ofNullable(map.get(key))
                .map(value -> Double.parseDouble(value.toString()))
                .orElse(0.0);
    }
}