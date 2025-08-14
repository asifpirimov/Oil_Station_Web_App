package com.example.Oil_Station.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Oil_Station.dto.OilDTO;
import com.example.Oil_Station.entity.Oil;
import com.example.Oil_Station.exception.OilNotFoundException;
import com.example.Oil_Station.mapper.OilMapper;
import com.example.Oil_Station.repository.OilRepository;

@Service
public class OilServiceImpl implements OilService{
    private final OilRepository oilRepo;
    private final OilMapper oilMapper;


    public OilServiceImpl(OilRepository oilRepo, OilMapper oilMapper) {
        this.oilRepo = oilRepo;
        this.oilMapper = oilMapper;
    }


    @Override
    public OilDTO addOil(OilDTO oilDTO) {
        Oil oil = oilMapper.toEntity(oilDTO);
        Oil savedOil = oilRepo.save(oil);
        return oilMapper.toDTO(savedOil);
    }


    @Override
    public void deleteOil(Long id) {
        if(!oilRepo.existsById(id)) {
            throw new OilNotFoundException(id);
        }
        oilRepo.deleteById(id);
        
    }


    @Override
    public List<OilDTO> getAllOils() {
        return oilRepo.findAll().stream()
                    .map(oilMapper::toDTO)
                    .collect(Collectors.toList());
    }


    @Override
    public OilDTO getOilById(Long id) {
        Oil oil = oilRepo.findById(id)
            .orElseThrow(() -> new OilNotFoundException(id));
        return oilMapper.toDTO(oil);
    }


    @Override
    public OilDTO updateOil(Long id, OilDTO oilDTO) {
        Oil oil = oilRepo.findById(id)
            .orElseThrow(() -> new OilNotFoundException(id));
        oil.setBrandName(oilDTO.getBrandName());
        oil.setProductName(oilDTO.getProductName());
        oil.setOilType(oilDTO.getOilType());
        oil.setViscosityGrade(oilDTO.getViscosityGrade());
        oil.setPrice(oilDTO.getPrice());
        oil.setImageUrl(oilDTO.getImageUrl());
        Oil updatedOil = oilRepo.save(oil);
        return oilMapper.toDTO(updatedOil);
    }

    

    
}
