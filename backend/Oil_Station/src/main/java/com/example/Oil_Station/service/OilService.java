package com.example.Oil_Station.service;

import java.util.List;

import com.example.Oil_Station.entity.Oil;


public interface OilService {
    Oil addOil(Oil oilDTO);
    Oil getOilById(Long id);
    List<Oil> getAllOils();
    Oil updateOil(Long id, Oil oilDTO);
    void deleteOil(Long id);

}
