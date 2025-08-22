package com.buen.orden.payments.apiBuenOrden.model;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MonthlyPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Name("payment_date")
    private LocalDate paymentDate;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "jugador_id", nullable = false)
    private Player player;


}
