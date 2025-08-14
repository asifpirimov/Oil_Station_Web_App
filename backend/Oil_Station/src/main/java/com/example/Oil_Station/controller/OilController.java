package com.example.Oil_Station.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Oil_Station.dto.OilDTO;
import com.example.Oil_Station.service.OilService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/oils")
public class OilController {
    @Autowired
    private OilService oilService;

    @GetMapping
    public List<OilDTO> getAllOils() {
        return oilService.getAllOils();
    }

    @GetMapping("/{id}")
    public OilDTO getOilById(@PathVariable Long id) {
        return oilService.getOilById(id);
    }

    @PostMapping
    public OilDTO addOil(@Valid @RequestBody OilDTO oilDTO) {
        return oilService.addOil(oilDTO);
    }

    @PutMapping("/{id}")
    public OilDTO updateBook(@PathVariable Long id, @Valid @RequestBody OilDTO oilDTO) {
        return oilService.updateOil(id, oilDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        oilService.deleteOil(id);
    }
}
