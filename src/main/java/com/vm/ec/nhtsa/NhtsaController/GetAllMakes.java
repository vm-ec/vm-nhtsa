package com.vm.ec.nhtsa.NhtsaController;

import com.vm.ec.nhtsa.service.NhtsaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class GetAllMakes {

    private final NhtsaService nhtsaService;

    public GetAllMakes(NhtsaService nhtsaService) {
        this.nhtsaService = nhtsaService;
    }

    @GetMapping("/api/getAllMakes")
    public String getAllMakes() {
        return nhtsaService.fetchAllMakes();
    }
}