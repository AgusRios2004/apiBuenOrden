package com.buen.orden.payments.apiBuenOrden.model;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Name("last_name")
    private String lastName;
    private LocalDate birthDate;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MonthlyPayment> payments;
}