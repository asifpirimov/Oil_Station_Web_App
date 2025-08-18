package com.example.Oil_Station.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Oil_Station.entity.Oil;
import com.example.Oil_Station.service.OilService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/oils")
@CrossOrigin(origins="*")
public class OilController {
    @Autowired
    private OilService oilService;

    @GetMapping
    public List<Oil> getAllOils() {
        return oilService.getAllOils();
    }

    @GetMapping("/{id}")
    public Oil getOilById(@PathVariable Long id) {
        return oilService.getOilById(id);
    }

    @PostMapping
    public Oil addOil(@RequestBody Oil oil) {
        return oilService.addOil(oil);
    }

    @PutMapping("/{id}")
    public Oil updateBook(@PathVariable Long id, @Valid @RequestBody Oil oil) {
        return oilService.updateOil(id, oil);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        oilService.deleteOil(id);
    }
}
