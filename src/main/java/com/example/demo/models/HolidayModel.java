package com.example.demo.models;


import lombok.Builder;

@Builder
public record HolidayModel(
        String date,
        String localName,
        String name,
        String countryCode,
        boolean fixed,
        boolean global,
        String[] counties,
        Integer launchYear,
        String type
) {}