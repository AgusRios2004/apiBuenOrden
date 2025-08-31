package com.buen.orden.payments.apiBuenOrden.service;

import com.buen.orden.payments.apiBuenOrden.dto.request.PlayerRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.PlayerResponseDTO;
import com.buen.orden.payments.apiBuenOrden.mappers.PlayerMapper;
import com.buen.orden.payments.apiBuenOrden.model.Player;
import com.buen.orden.payments.apiBuenOrden.model.State;
import com.buen.orden.payments.apiBuenOrden.repository.PlayerRepository;
import com.buen.orden.payments.apiBuenOrden.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private StateRepository stateRepository;

    public PlayerResponseDTO create(PlayerRequestDTO dto) {
        Player player = PlayerMapper.toEntity(dto);

        State state = stateRepository.findById(dto.getStateId())
                .orElseThrow(() -> new RuntimeException("State not found"));

        player.setState(state);
        Player saved = playerRepository.save(player);

        return PlayerMapper.toDTO(saved);
    }

    public List<PlayerResponseDTO> getAll() {
        return playerRepository.findAll()
                .stream()
                .map(PlayerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PlayerResponseDTO getById(Long id) {
        return playerRepository.findById(id)
                .map(PlayerMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }

    public PlayerResponseDTO update(Long id, PlayerRequestDTO dto) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        player.setName(dto.getName());
        player.setLastName(dto.getLastName());
        player.setBirthDate(dto.getBirthDate());

        if (dto.getStateId() != null) {
            State state = stateRepository.findById(dto.getStateId())
                    .orElseThrow(() -> new RuntimeException("State not found"));
            player.setState(state);
        }

        return PlayerMapper.toDTO(playerRepository.save(player));
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }
}
