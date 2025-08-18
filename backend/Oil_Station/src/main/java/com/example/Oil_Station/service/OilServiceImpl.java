package com.example.Oil_Station.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Oil_Station.entity.Oil;
import com.example.Oil_Station.exception.OilNotFoundException;
import com.example.Oil_Station.repository.OilRepository;

@Service
public class OilServiceImpl implements OilService{
    private final OilRepository oilRepo;


    public OilServiceImpl(OilRepository oilRepo) {
        this.oilRepo = oilRepo;
    }


    @Override
    public Oil addOil(Oil oil) {
        return oilRepo.save(oil);
    }


    @Override
    public void deleteOil(Long id) {
        if(!oilRepo.existsById(id)) {
            throw new OilNotFoundException(id);
        }
        oilRepo.deleteById(id);
        
    }


    @Override
    public List<Oil> getAllOils() {
        return oilRepo.findAll().stream()
                    .collect(Collectors.toList());
    }


    @Override
    public Oil getOilById(Long id) {
        Oil oil = oilRepo.findById(id)
            .orElseThrow(() -> new OilNotFoundException(id));
        return oil;
    }


    @Override
    public Oil updateOil(Long id, Oil Oil) {
        Oil oil = oilRepo.findById(id)
            .orElseThrow(() -> new OilNotFoundException(id));
        oil.setBrandName(Oil.getBrandName());
        oil.setProductName(Oil.getProductName());
        oil.setOilType(Oil.getOilType());
        oil.setViscosityGrade(Oil.getViscosityGrade());
        oil.setPrice(Oil.getPrice());
        oil.setImageUrl(Oil.getImageUrl());
        Oil updatedOil = oilRepo.save(oil);
        return updatedOil;
    }

    

    
}
