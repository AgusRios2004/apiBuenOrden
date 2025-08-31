package com.buen.orden.payments.apiBuenOrden.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PlayerRequestDTO {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private Long stateId;
}
