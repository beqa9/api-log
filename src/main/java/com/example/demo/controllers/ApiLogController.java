package com.example.demo.controllers;


import com.example.demo.mappers.ApiLogMapper;
import com.example.demo.models.ApiLogModel;
import com.example.demo.repositories.ApiLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class ApiLogController {

    private final ApiLogRepository apiLogRepository;
    private final ApiLogMapper apiLogMapper;

    @GetMapping
    public List<ApiLogModel> getAllLogs() {
        return apiLogMapper.toModelList(apiLogRepository.findAll());
    }
}