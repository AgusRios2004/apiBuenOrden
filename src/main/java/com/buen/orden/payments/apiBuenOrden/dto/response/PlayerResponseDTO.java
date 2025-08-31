package com.buen.orden.payments.apiBuenOrden.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private String birthDate;
    private String stateName;
}
