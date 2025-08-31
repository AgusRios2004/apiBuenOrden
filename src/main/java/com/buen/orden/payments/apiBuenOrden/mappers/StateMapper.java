package com.buen.orden.payments.apiBuenOrden.mappers;

import com.buen.orden.payments.apiBuenOrden.dto.response.StateResponseDTO;
import com.buen.orden.payments.apiBuenOrden.model.State;

import java.util.stream.Collectors;

public class StateMapper {

    public static StateResponseDTO toDTO(State state) {
        if (state == null) return null;

        StateResponseDTO dto = new StateResponseDTO();
        dto.setId(state.getId());
        dto.setName(state.getName());
        dto.setPlayers(
                state.getPlayers() != null
                        ? state.getPlayers().stream()
                        .map(PlayerMapper::toDTO)
                        .collect(Collectors.toList())
                        : null
        );
        return dto;
    }
}
