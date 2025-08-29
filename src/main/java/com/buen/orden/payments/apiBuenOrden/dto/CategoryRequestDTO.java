package com.buen.orden.payments.apiBuenOrden.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CategoryRequestDTO {
    private Long id;
    private String name;
    private List<Long> disciplineIds; // Solo IDs
}
