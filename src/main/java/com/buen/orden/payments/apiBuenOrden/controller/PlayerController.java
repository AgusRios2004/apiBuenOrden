package com.buen.orden.payments.apiBuenOrden.controller;

import com.buen.orden.payments.apiBuenOrden.dto.request.PlayerRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.PlayerResponseDTO;
import com.buen.orden.payments.apiBuenOrden.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public PlayerResponseDTO create(@RequestBody PlayerRequestDTO dto) {
        return playerService.create(dto);
    }

    @GetMapping
    public List<PlayerResponseDTO> getAll() {
        return playerService.getAll();
    }

    @GetMapping("/{id}")
    public PlayerResponseDTO getById(@PathVariable Long id) {
        return playerService.getById(id);
    }

    @PutMapping("/{id}")
    public PlayerResponseDTO update(@PathVariable Long id, @RequestBody PlayerRequestDTO dto) {
        return playerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }
}
