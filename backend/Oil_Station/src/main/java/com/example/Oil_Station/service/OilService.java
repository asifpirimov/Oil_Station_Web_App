package com.example.Oil_Station.service;

import java.util.List;

import com.example.Oil_Station.dto.OilDTO;

public interface OilService {
    OilDTO addOil(OilDTO oilDTO);
    OilDTO getOilById(Long id);
    List<OilDTO> getAllOils();
    OilDTO updateOil(Long id, OilDTO oilDTO);
    void deleteOil(Long id);

}
