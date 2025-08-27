package com.buen.orden.payments.apiBuenOrden.mappers;

import com.buen.orden.payments.apiBuenOrden.dto.CategoryDTO;
import com.buen.orden.payments.apiBuenOrden.model.Category;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category category){
        if(category == null) return null;
        return new CategoryDTO(category.getId(), category.getName());
    }

    public static Category toEntity(CategoryDTO dto){
        if(dto == null) return null;
        Category c = new Category();
        c.setId(dto.getId());
        c.setName(dto.getName());
        return c;
    }

}