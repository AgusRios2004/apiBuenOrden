package com.buen.orden.payments.apiBuenOrden.dto.response;

import com.buen.orden.payments.apiBuenOrden.dto.DisciplineDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private List<DisciplineDTO> disciplines; // Objetos completos (id + name)
}
