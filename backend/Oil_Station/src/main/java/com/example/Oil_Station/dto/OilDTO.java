package com.example.Oil_Station.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OilDTO {
    private String brandName;
    private String productName;
    private String oilType;
    private String viscosityGrade;
    private Double price;
    private String imageUrl;
}
