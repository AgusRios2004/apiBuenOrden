package com.buen.orden.payments.apiBuenOrden.mappers;

import com.buen.orden.payments.apiBuenOrden.dto.request.PlayerCategoryHistoryRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.PlayerCategoryHistoryResponseDTO;
import com.buen.orden.payments.apiBuenOrden.model.PlayerCategoryHistory;

public class PlayerCategoryHistoryMapper {

    public static PlayerCategoryHistory toEntity(PlayerCategoryHistoryRequestDTO dto) {
        return new PlayerCategoryHistory(
                null,
                dto.getDescription(),
                dto.getDateSince(),
                dto.getDateUntil()
        );
    }

    public static PlayerCategoryHistoryResponseDTO toResponseDTO(PlayerCategoryHistory entity) {
        return new PlayerCategoryHistoryResponseDTO(
                entity.getId(),
                entity.getDescription(),
                entity.getDateSince(),
                entity.getDateUntil()
        );
    }
}
