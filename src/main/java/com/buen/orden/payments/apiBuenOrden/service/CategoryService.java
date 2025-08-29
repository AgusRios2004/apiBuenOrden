package com.buen.orden.payments.apiBuenOrden.service;

import com.buen.orden.payments.apiBuenOrden.dto.CategoryRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.CategoryResponseDTO;
import com.buen.orden.payments.apiBuenOrden.mappers.CategoryMapper;
import com.buen.orden.payments.apiBuenOrden.model.Category;
import com.buen.orden.payments.apiBuenOrden.repository.CategoryRepository;
import com.buen.orden.payments.apiBuenOrden.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    // Get all (devuelvo ResponseDTO)
    public List<CategoryResponseDTO> getAllCategories(){
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Get by id
    public Optional<CategoryResponseDTO> getCategoryById(Long id){
        return categoryRepository.findById(id).map(CategoryMapper::toResponseDTO);
    }

    // Create
    public CategoryResponseDTO createCategory(CategoryRequestDTO dto){
        Category c = CategoryMapper.toEntity(dto);
        if (dto.getDisciplineIds() != null) {
            c.setDisciplines(disciplineRepository.findAllById(dto.getDisciplineIds()));
        }
        Category saved = categoryRepository.save(c);
        return CategoryMapper.toResponseDTO(saved);
    }

    // Update
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto){
        return categoryRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    if (dto.getDisciplineIds() != null) {
                        existing.setDisciplines(
                                disciplineRepository.findAllById(dto.getDisciplineIds())
                        );
                    }
                    Category updated = categoryRepository.save(existing);
                    return CategoryMapper.toResponseDTO(updated);
                })
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    }

    // Delete
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
