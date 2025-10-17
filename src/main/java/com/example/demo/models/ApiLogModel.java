package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Builder
public record ApiLogModel(
        Long id,
        String endpoint,
        String httpMethod,
        String requestParams,
        String responseBody,
        Integer statusCode,
        Integer executionTimeMs,
        OffsetDateTime createdAt
) {}