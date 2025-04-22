package com.supabse.demo.service;

import com.supabse.demo.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SupabaseService {

    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.key}")
    private String supabaseKey;
    private final RestTemplate restTemplate;

    public SupabaseService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;

    }

    public List<EmployeeDto> getAllEmployees(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("apiKey", supabaseKey);
        httpHeaders.set("Authorization","Bearer "+supabaseKey);
        httpHeaders.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<EmployeeDto[]> response = restTemplate.exchange(
                supabaseUrl +"/rest/v1/employee?select=*",
                HttpMethod.GET,
                entity,
                EmployeeDto[].class
        );
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
