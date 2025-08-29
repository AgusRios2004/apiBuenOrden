package com.buen.orden.payments.apiBuenOrden.controller;

import com.buen.orden.payments.apiBuenOrden.api.ApiResponse;
import com.buen.orden.payments.apiBuenOrden.dto.DisciplineDTO;
import com.buen.orden.payments.apiBuenOrden.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<DisciplineDTO>>> getAll(){
        List<DisciplineDTO> disciplines = disciplineService.getDisciplines();
        ApiResponse<List<DisciplineDTO>> response =
                new ApiResponse<>(true, "Disciplines fetched", disciplines);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DisciplineDTO>> getDisciplineById(@PathVariable Long id){
        Optional<DisciplineDTO> optionalDiscipline = disciplineService.getDisciplineByID(id);
        if (optionalDiscipline.isPresent()) {
            ApiResponse<DisciplineDTO> response =
                    new ApiResponse<>(true, "Discipline found", optionalDiscipline.get());
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<DisciplineDTO> response =
                    new ApiResponse<>(false, "Discipline not found", null);
            return ResponseEntity.status(404).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DisciplineDTO>> createDiscipline(@RequestBody DisciplineDTO dto){
        DisciplineDTO created = disciplineService.createDiscipline(dto);
        ApiResponse<DisciplineDTO> response =
                new ApiResponse<>(true, "Discipline created", created);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DisciplineDTO>> updateDiscipline(
            @PathVariable Long id,
            @RequestBody DisciplineDTO dto) {

        DisciplineDTO updated = disciplineService.updateDiscipline(id, dto);
        ApiResponse<DisciplineDTO> response =
                new ApiResponse<>(true, "Discipline updated", updated);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteDiscipline(@PathVariable Long id){
        disciplineService.deleteDiscipline(id);
        ApiResponse<Void> response =
                new ApiResponse<>(true, "Discipline deleted", null);
        return ResponseEntity.ok(response);
    }
}