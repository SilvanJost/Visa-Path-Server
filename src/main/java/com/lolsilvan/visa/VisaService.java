package com.lolsilvan.visa;

import com.lolsilvan.visa.data.VisaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaService {

    private final VisaRepository visaRepository;

    public VisaService(VisaRepository visaRepository) {
        this.visaRepository = visaRepository;
    }

    public List<Visa> getByCountry(String country) {
        return visaRepository.getByCountry(country);
    }
}
