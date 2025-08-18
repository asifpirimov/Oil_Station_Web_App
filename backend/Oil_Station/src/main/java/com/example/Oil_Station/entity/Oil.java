package com.example.Oil_Station.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "oils")
public class Oil {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="brand_name")
    private String brandName;

    @Column(name="product_name")
    private String productName;

    @Column(name="oil_type")
    private String oilType;

    @Column(name="viscosity_grade")
    private String viscosityGrade;

    @Column(name="price")
    private Double price;

    @Column(name="image_url")
    private String imageUrl;

}
