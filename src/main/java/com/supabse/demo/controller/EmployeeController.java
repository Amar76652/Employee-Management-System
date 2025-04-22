package com.supabse.demo.controller;

import com.supabse.demo.dto.EmployeeDto;
import com.supabse.demo.service.SupabaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final SupabaseService supabaseService;

    public EmployeeController(SupabaseService supabaseService){
        this .supabaseService = supabaseService;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return supabaseService.getAllEmployees();
    }

}
