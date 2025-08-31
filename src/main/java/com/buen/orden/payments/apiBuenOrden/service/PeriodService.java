package com.buen.orden.payments.apiBuenOrden.service;

import com.buen.orden.payments.apiBuenOrden.dto.request.PeriodRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.PeriodResponseDTO;
import com.buen.orden.payments.apiBuenOrden.mappers.PeriodMapper;
import com.buen.orden.payments.apiBuenOrden.model.Period;
import com.buen.orden.payments.apiBuenOrden.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodService {

    @Autowired
    private PeriodRepository periodRepository;

    public List<PeriodResponseDTO> getAll() {
        return periodRepository.findAll().stream()
                .map(PeriodMapper::toResponseDTO)
                .toList();
    }

    public Optional<PeriodResponseDTO> getById(Long id) {
        return periodRepository.findById(id).map(PeriodMapper::toResponseDTO);
    }

    public PeriodResponseDTO create(PeriodRequestDTO dto) {
        Period saved = periodRepository.save(PeriodMapper.toEntity(dto));
        return PeriodMapper.toResponseDTO(saved);
    }

    public Optional<PeriodResponseDTO> update(Long id, PeriodRequestDTO dto) {
        return periodRepository.findById(id).map(period -> {
            period.setDescription(dto.getDescription());
            Period updated = periodRepository.save(period);
            return PeriodMapper.toResponseDTO(updated);
        });
    }

    public void delete(Long id) {
        periodRepository.deleteById(id);
    }
}
