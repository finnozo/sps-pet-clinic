package org.pyarts.spspetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @GetMapping({"", "/", "/index", "/index.html"})
    public String listOwners() {
        return "owners/index";
    }
}
