package com.buen.orden.payments.apiBuenOrden.service;

import com.buen.orden.payments.apiBuenOrden.dto.request.PlayerCategoryHistoryRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.PlayerCategoryHistoryResponseDTO;
import com.buen.orden.payments.apiBuenOrden.mappers.PlayerCategoryHistoryMapper;
import com.buen.orden.payments.apiBuenOrden.model.PlayerCategoryHistory;
import com.buen.orden.payments.apiBuenOrden.repository.PlayerCategoryHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerCategoryHistoryService {

    @Autowired
    private PlayerCategoryHistoryRepository repository;

    public PlayerCategoryHistoryResponseDTO create(PlayerCategoryHistoryRequestDTO dto) {
        PlayerCategoryHistory history = PlayerCategoryHistoryMapper.toEntity(dto);
        return PlayerCategoryHistoryMapper.toResponseDTO(repository.save(history));
    }

    public List<PlayerCategoryHistoryResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(PlayerCategoryHistoryMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PlayerCategoryHistoryResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(PlayerCategoryHistoryMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
