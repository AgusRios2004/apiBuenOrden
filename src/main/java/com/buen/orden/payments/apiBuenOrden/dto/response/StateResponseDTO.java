package com.buen.orden.payments.apiBuenOrden.dto.response;

import com.buen.orden.payments.apiBuenOrden.dto.PlayerDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StateResponseDTO {
    private Long id;
    private String name;
    private List<PlayerDTO> players;
}
