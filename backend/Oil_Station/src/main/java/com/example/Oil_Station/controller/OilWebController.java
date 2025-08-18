package com.example.Oil_Station.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Oil_Station.entity.Oil;
import com.example.Oil_Station.service.OilService;

@Controller
public class OilWebController {
    private final OilService oilService;

    public OilWebController(OilService oilService) {
        this.oilService = oilService;
    }

    @GetMapping("/")
    public String redirectToOils() {
        return "redirect:/oils";
    }

    @GetMapping("/oils")
    public String listOils(Model model) {
        model.addAttribute("oils", oilService.getAllOils());
        return "oils";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("oil", new Oil());
        return "oil_form";
    }

    @PostMapping("/oils")
    public String createOil(@ModelAttribute Oil oil) {
        oilService.addOil(oil);
        return "redirect:/oils";
    }

    @GetMapping("/oils/update/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Oil oil = oilService.getOilById(id);
        model.addAttribute("oil", oil);
        return "oil_form";
    }

    @PostMapping("/oils/update/{id}")
    public String updateOil(@PathVariable Long id, @ModelAttribute Oil oil) {
        oilService.updateOil(id, oil);
        return "redirect:/oils";
    }

     @GetMapping("/delete/{id}")
    public String deleteOil(@PathVariable Long id) {
        oilService.deleteOil(id);
        return "redirect:/oils";
    }


    @GetMapping("/{id}")
    public String viewOil(@PathVariable Long id, Model model) {
        Oil oil = oilService.getOilById(id);
        model.addAttribute("oil", oil);
        return "oil_detail";
    }
    

    
}
