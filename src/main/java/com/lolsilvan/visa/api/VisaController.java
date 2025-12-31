package com.lolsilvan.visa.api;

import com.lolsilvan.visa.Visa;
import com.lolsilvan.visa.VisaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/visas")
public class VisaController {

    private final VisaService visaService;

    public VisaController(VisaService visaService) {
        this.visaService = visaService;
    }

    @GetMapping
    public ResponseEntity<List<Visa>> getByCountry(String country) {
        return ResponseEntity.ok(visaService.getByCountry(country));
    }
}
