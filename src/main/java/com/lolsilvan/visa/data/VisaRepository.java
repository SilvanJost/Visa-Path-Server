package com.lolsilvan.visa.data;

import com.lolsilvan.visa.Visa;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VisaRepository {

    private final ObjectMapper objectMapper;
    private final ResourcePatternResolver resolver;

    private Map<String, CountryData> visasByCountry;

    public VisaRepository(ResourcePatternResolver resolver, ObjectMapper objectMapper) {
        this.resolver = resolver;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() throws Exception {
        Resource[] resources = resolver.getResources("classpath:visas/*.json");

        Map<String, CountryData> map = new HashMap<>();

        for (Resource resource : resources) {
            String filename = resource.getFilename();
            if (filename == null || !filename.endsWith(".json")) continue;

            String country = filename.replace(".json", "");
            CountryData data = objectMapper.readValue(resource.getInputStream(), CountryData.class);
            map.put(country.toLowerCase(), data);
        }

        visasByCountry = Map.copyOf(map);
        System.out.println("Loaded " + visasByCountry.size() + " visa files");
    }

    public List<Visa> getByCountry(String countryCode) {
        return visasByCountry.get(countryCode.toLowerCase()).visas();
    }
}
