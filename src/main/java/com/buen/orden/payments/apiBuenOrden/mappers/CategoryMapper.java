package com.buen.orden.payments.apiBuenOrden.mappers;

import com.buen.orden.payments.apiBuenOrden.dto.request.CategoryRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.CategoryResponseDTO;
import com.buen.orden.payments.apiBuenOrden.dto.DisciplineDTO;
import com.buen.orden.payments.apiBuenOrden.model.Category;

import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryResponseDTO toResponseDTO(Category category) {
        if (category == null) return null;
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getDisciplines() != null
                        ? category.getDisciplines().stream()
                        .map(d -> new DisciplineDTO(d.getId(), d.getName()))
                        .collect(Collectors.toList())
                        : null
        );
    }

    public static Category toEntity(CategoryRequestDTO dto) {
        if (dto == null) return null;
        Category c = new Category();
        c.setId(dto.getId());
        c.setName(dto.getName());
        return c;
    }
}
