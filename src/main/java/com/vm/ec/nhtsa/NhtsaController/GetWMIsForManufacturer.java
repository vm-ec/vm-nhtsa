package com.vm.ec.nhtsa.NhtsaController;

import com.vm.ec.nhtsa.service.NhtsaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
public class GetWMIsForManufacturer {

    private final NhtsaService nhtsaService;

    public GetWMIsForManufacturer(NhtsaService nhtsaService) {
        this.nhtsaService = nhtsaService;
    }

    @GetMapping("/api/getWMIsForManufacturer/{manufacturer}")
    public String getWMIsForManufacturer(@PathVariable String manufacturer) {
        return nhtsaService.fetchWMIsForManufacturer(manufacturer);
    }
}