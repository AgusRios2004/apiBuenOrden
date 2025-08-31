package com.buen.orden.payments.apiBuenOrden.controller;

import com.buen.orden.payments.apiBuenOrden.api.ApiResponse;
import com.buen.orden.payments.apiBuenOrden.dto.request.PeriodRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.PeriodResponseDTO;
import com.buen.orden.payments.apiBuenOrden.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/periods")
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<PeriodResponseDTO>>> getAll() {
        List<PeriodResponseDTO> periods = periodService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(true, "Periods found", periods));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PeriodResponseDTO>> getById(@PathVariable Long id) {
        Optional<PeriodResponseDTO> optional = periodService.getById(id);
        return optional.<ResponseEntity<ApiResponse<PeriodResponseDTO>>>map(periodResponseDTO -> ResponseEntity.ok(new ApiResponse<>(true, "Period found", periodResponseDTO))).orElseGet(() -> ResponseEntity.status(404).body(new ApiResponse<>(false, "Period not found", null)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PeriodResponseDTO>> create(@RequestBody PeriodRequestDTO dto) {
        PeriodResponseDTO created = periodService.create(dto);
        return ResponseEntity.status(201).body(new ApiResponse<>(true, "Period created", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PeriodResponseDTO>> update(@PathVariable Long id,
                                                                 @RequestBody PeriodRequestDTO dto) {
        Optional<PeriodResponseDTO> updated = periodService.update(id, dto);
        if (updated.isPresent()) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Period updated", updated.get()));
        }
        return ResponseEntity.status(404).body(new ApiResponse<>(false, "Period not found", null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        periodService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Period deleted", null));
    }
}
