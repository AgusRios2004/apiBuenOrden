package com.buen.orden.payments.apiBuenOrden.mappers;

import com.buen.orden.payments.apiBuenOrden.dto.request.MonthlyPaymentRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.MonthlyPaymentResponseDTO;
import com.buen.orden.payments.apiBuenOrden.model.MonthlyPayment;
import com.buen.orden.payments.apiBuenOrden.model.Player;

public class MonthlyPaymentMapper {

    public static MonthlyPayment toEntity(MonthlyPaymentRequestDTO dto, Player player) {
        MonthlyPayment payment = new MonthlyPayment();
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setAmount(dto.getAmount());
        payment.setPlayer(player);
        return payment;
    }

    public static MonthlyPaymentResponseDTO toResponseDTO(MonthlyPayment entity) {
        return new MonthlyPaymentResponseDTO(
                entity.getId(),
                entity.getPaymentDate(),
                entity.getAmount(),
                entity.getPlayer() != null ? entity.getPlayer().getId() : null,
                entity.getPlayer() != null ? entity.getPlayer().getName() : null
        );
    }
}
