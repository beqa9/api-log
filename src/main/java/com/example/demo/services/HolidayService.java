package com.example.demo.services;

import com.example.demo.models.HolidayModel;

import java.util.List;

public interface HolidayService {
    List<HolidayModel> getPublicHolidays(String countryCode, int year);
}
