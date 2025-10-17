package com.example.demo.repositories;

import com.example.demo.entities.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApiLogRepository extends JpaRepository<ApiLog, Long> {

}