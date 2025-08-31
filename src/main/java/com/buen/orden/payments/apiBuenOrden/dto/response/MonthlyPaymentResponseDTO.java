package com.buen.orden.payments.apiBuenOrden.dto.response;

import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MonthlyPaymentResponseDTO {
    private Long id;
    private LocalDate paymentDate;
    private double amount;
    private Long playerId;
    private String playerName; // opcional para mostrar info básica del jugador
}