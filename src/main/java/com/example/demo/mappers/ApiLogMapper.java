package com.example.demo.mappers;


import com.example.demo.entities.ApiLog;
import com.example.demo.models.ApiLogModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApiLogMapper {

    ApiLogModel toModel(ApiLog log);

    List<ApiLogModel> toModelList(List<ApiLog> logs);
}