package com.example.Oil_Station.mapper;

import org.springframework.context.annotation.Configuration;

import com.example.Oil_Station.dto.OilDTO;
import com.example.Oil_Station.entity.Oil;

@Configuration
public class OilMapper {
    public OilDTO toDTO(Oil oil) {
        return OilDTO.builder()
            .brandName(oil.getBrandName())
            .productName(oil.getProductName())
            .oilType(oil.getOilType())
            .viscosityGrade(oil.getViscosityGrade())
            .price(oil.getPrice())
            .imageUrl(oil.getImageUrl())
            .build();
    }

    public Oil toEntity(OilDTO oil) {
        return Oil.builder()
            .brandName(oil.getBrandName())
            .productName(oil.getProductName())
            .oilType(oil.getOilType())
            .viscosityGrade(oil.getViscosityGrade())
            .price(oil.getPrice())
            .imageUrl(oil.getImageUrl())
            .build();
    }

}
