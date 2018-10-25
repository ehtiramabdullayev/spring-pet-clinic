package com.springframework.springpetclinic.controllers;

import com.springframework.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ehtiram_Abdullayev on 8/30/2018
 * @project spring-pet-clinic
 */
@Controller
public class VetController {
    private VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"vets/", "vets/index", "vets/index.html", "/vets.html"})
    public String listVets(Model model){
        vetService.findAll().forEach(vet -> System.out.println());
        model.addAttribute("vets",vetService.findAll());

        return "vets/index";
    }
}
