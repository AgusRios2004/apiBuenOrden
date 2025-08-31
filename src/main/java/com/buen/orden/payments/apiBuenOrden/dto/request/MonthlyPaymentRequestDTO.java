package com.buen.orden.payments.apiBuenOrden.dto.request;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MonthlyPaymentRequestDTO {
    private LocalDate paymentDate;
    private double amount;
    private Long playerId; // Solo enviamos el id del jugador
}
