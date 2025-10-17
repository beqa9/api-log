package com.example.demo.controllers;

import com.example.demo.models.HolidayModel;
import com.example.demo.services.HolidayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/holidays")
@Tag(name = "holiday-controller", description = "Fetch and log public holidays")
@RequiredArgsConstructor
public class HolidayController {

    private final HolidayService holidayService;

    @GetMapping("/{countryCode}/{year}")
    public List<HolidayModel> getHolidays(
            @PathVariable String countryCode,
            @PathVariable int year
    ) {
        return holidayService.getPublicHolidays(countryCode, year);
    }
}