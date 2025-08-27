package com.buen.orden.payments.apiBuenOrden.service;

import com.buen.orden.payments.apiBuenOrden.dto.CategoryDTO;
import com.buen.orden.payments.apiBuenOrden.mappers.CategoryMapper;
import com.buen.orden.payments.apiBuenOrden.model.Category;
import com.buen.orden.payments.apiBuenOrden.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CategoryDTO> getCategoryById(Long id){
        return categoryRepository.findById(id).map(CategoryMapper::toDTO);
    }

    public CategoryDTO createCategory(CategoryDTO dto){
        Category c = CategoryMapper.toEntity(dto);
        Category saved = categoryRepository.save(c);
        return CategoryMapper.toDTO(saved);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

}