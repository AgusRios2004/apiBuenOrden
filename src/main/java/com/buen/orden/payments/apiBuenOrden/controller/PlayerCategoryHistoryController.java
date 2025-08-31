package com.buen.orden.payments.apiBuenOrden.controller;

import com.buen.orden.payments.apiBuenOrden.dto.request.PlayerCategoryHistoryRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.PlayerCategoryHistoryResponseDTO;
import com.buen.orden.payments.apiBuenOrden.service.PlayerCategoryHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player-category-history")
public class PlayerCategoryHistoryController {
    private final PlayerCategoryHistoryService service;

    public PlayerCategoryHistoryController(PlayerCategoryHistoryService service) {
        this.service = service;
    }

    @PostMapping
    public PlayerCategoryHistoryResponseDTO create(@RequestBody PlayerCategoryHistoryRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<PlayerCategoryHistoryResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PlayerCategoryHistoryResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
