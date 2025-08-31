package com.buen.orden.payments.apiBuenOrden.controller;

import com.buen.orden.payments.apiBuenOrden.dto.request.StateRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.StateResponseDTO;
import com.buen.orden.payments.apiBuenOrden.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @PostMapping
    public StateResponseDTO create(@RequestBody StateRequestDTO dto) {
        return stateService.create(dto);
    }

    @GetMapping
    public List<StateResponseDTO> getAll() {
        return stateService.getAll();
    }

    @GetMapping("/{id}")
    public StateResponseDTO getById(@PathVariable Long id) {
        return stateService.getById(id);
    }

    @PutMapping("/{id}")
    public StateResponseDTO update(@PathVariable Long id, @RequestBody StateRequestDTO dto) {
        return stateService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        stateService.delete(id);
    }
}
