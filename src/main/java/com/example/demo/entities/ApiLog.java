package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "api_logs")
public class ApiLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String endpoint;

    @Column(name = "http_method", nullable = false)
    private String httpMethod = "GET";

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "request_params")
    private String requestParams;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "response_body")
    private String responseBody;

    @Column(name = "status_code")
    private Integer statusCode;

    @Column(name = "execution_time_ms")
    private Integer executionTimeMs;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

}