package com.buen.orden.payments.apiBuenOrden.mappers;

import com.buen.orden.payments.apiBuenOrden.dto.request.PlayerRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.PlayerResponseDTO;
import com.buen.orden.payments.apiBuenOrden.model.Player;

public class PlayerMapper {

    public static PlayerResponseDTO toDTO(Player player) {
        if (player == null) return null;

        PlayerResponseDTO dto = new PlayerResponseDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setLastName(player.getLastName());
        dto.setBirthDate(player.getBirthDate().toString());
        dto.setStateName(player.getState() != null ? player.getState().getName() : null);
        return dto;
    }

    public static Player toEntity(PlayerRequestDTO dto) {
        if (dto == null) return null;

        Player player = new Player();
        player.setName(dto.getName());
        player.setLastName(dto.getLastName());
        player.setBirthDate(dto.getBirthDate());
        return player;
    }
}
