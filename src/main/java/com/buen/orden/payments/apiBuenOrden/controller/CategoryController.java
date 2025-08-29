package com.buen.orden.payments.apiBuenOrden.controller;

import com.buen.orden.payments.apiBuenOrden.api.ApiResponse;
import com.buen.orden.payments.apiBuenOrden.dto.CategoryRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.CategoryResponseDTO;
import com.buen.orden.payments.apiBuenOrden.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponseDTO>>> getAll() {
        List<CategoryResponseDTO> categories = categoryService.getAllCategories();
        ApiResponse<List<CategoryResponseDTO>> response =
                new ApiResponse<>(true,"Categories fetched", categories);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDTO>> getCategoryById(@PathVariable Long id){
        Optional<CategoryResponseDTO> optionalCategory = categoryService.getCategoryById(id);
        if (optionalCategory.isPresent()) {
            ApiResponse<CategoryResponseDTO> response = new ApiResponse<>(
                    true,
                    "Category found",
                    optionalCategory.get()
            );
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<CategoryResponseDTO> response = new ApiResponse<>(
                    false,
                    "Category not found",
                    null
            );
            return ResponseEntity.status(404).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponseDTO>> createCategory(@RequestBody CategoryRequestDTO dto){
        CategoryResponseDTO created = categoryService.createCategory(dto);
        ApiResponse<CategoryResponseDTO> response =
                new ApiResponse<>(true, "Category created", created);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDTO>> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryRequestDTO dto) {

        CategoryResponseDTO updated = categoryService.updateCategory(id, dto);
        ApiResponse<CategoryResponseDTO> response =
                new ApiResponse<>(true, "Category updated", updated);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        ApiResponse<Void> response = new ApiResponse<>(true, "Category deleted", null);
        return ResponseEntity.ok(response);
    }
}
