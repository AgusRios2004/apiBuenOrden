package com.buen.orden.payments.apiBuenOrden.mappers;

import com.buen.orden.payments.apiBuenOrden.dto.request.PeriodRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.PeriodResponseDTO;
import com.buen.orden.payments.apiBuenOrden.model.Period;

public class PeriodMapper {

    public static PeriodResponseDTO toResponseDTO(Period period) {
        return new PeriodResponseDTO(period.getId(), period.getDescription());
    }

    public static Period toEntity(PeriodRequestDTO dto) {
        Period period = new Period();
        period.setDescription(dto.getDescription());
        return period;
    }
}
