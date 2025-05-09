package com.vm.ec.nhtsa.NhtsaController;

import com.vm.ec.nhtsa.service.NhtsaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class GetMakesForVehicle {
    private final NhtsaService nhtsaService;

    public GetMakesForVehicle(NhtsaService nhtsaService) {
        this.nhtsaService = nhtsaService;
    }

    @GetMapping("/api/getMakesForVehicle")
    public String GetMakesForVehicle() {
        return nhtsaService.fetchMakesForVehicle();
    }

}
