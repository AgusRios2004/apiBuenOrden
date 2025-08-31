package com.buen.orden.payments.apiBuenOrden.controller;

import com.buen.orden.payments.apiBuenOrden.dto.request.MonthlyPaymentRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.MonthlyPaymentResponseDTO;
import com.buen.orden.payments.apiBuenOrden.service.MonthlyPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monthly-payments")
public class MonthlyPaymentController {
    @Autowired
    private MonthlyPaymentService service;

    @PostMapping
    public MonthlyPaymentResponseDTO create(@RequestBody MonthlyPaymentRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<MonthlyPaymentResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MonthlyPaymentResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
