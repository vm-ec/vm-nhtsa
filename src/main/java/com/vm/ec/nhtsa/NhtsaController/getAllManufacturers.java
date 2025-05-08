package com.vm.ec.nhtsa.NhtsaController;

import com.vm.ec.nhtsa.service.NhtsaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
public class getAllManufacturers {
    private final NhtsaService nhtsaService;

    public getAllManufacturers(NhtsaService nhtsaService) {
        this.nhtsaService = nhtsaService;
    }

    @GetMapping("/api/getAllManufacturers")
    public String getAllManufacturers() {
        return nhtsaService.fetchAllManufacturers();
    }
}
