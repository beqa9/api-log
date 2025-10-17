package com.example.demo.services;

import com.example.demo.entities.ApiLog;
import com.example.demo.models.HolidayModel;
import com.example.demo.repositories.ApiLogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HolidayServiceImpl implements HolidayService {

    private final ApiLogRepository apiLogRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @Transactional
    public List<HolidayModel> getPublicHolidays(String countryCode, int year) {
        String url = "https://date.nager.at/api/v3/PublicHolidays/" + year + "/" + countryCode;
        RestTemplate restTemplate = new RestTemplate();

        long startTime = System.currentTimeMillis();
        List<HolidayModel> holidays;
        String responseJson;
        int statusCode;

        try {
            HolidayModel[] response = restTemplate.getForObject(url, HolidayModel[].class);
            holidays = Arrays.asList(response != null ? response : new HolidayModel[0]);
            responseJson = objectMapper.writeValueAsString(holidays);
            statusCode = 200;
        } catch (Exception e) {
            responseJson = "{\"error\": \"" + e.getMessage() + "\"}";
            holidays = List.of();
            statusCode = 500;
        }

        long executionTime = System.currentTimeMillis() - startTime;

        ApiLog log = new ApiLog();
        log.setEndpoint(url);
        log.setHttpMethod("GET");
        log.setRequestParams("{\"countryCode\": \"" + countryCode + "\", \"year\": " + year + "}");
        log.setResponseBody(responseJson);
        log.setStatusCode(statusCode);
        log.setExecutionTimeMs((int) executionTime);
        log.setCreatedAt(OffsetDateTime.now());

        apiLogRepository.save(log);

        if (statusCode != 200) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to fetch holidays");
        }

        return holidays;
    }
}