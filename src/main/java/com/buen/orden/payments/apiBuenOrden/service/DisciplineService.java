package com.buen.orden.payments.apiBuenOrden.service;

import com.buen.orden.payments.apiBuenOrden.dto.DisciplineDTO;
import com.buen.orden.payments.apiBuenOrden.mappers.DisciplineMapper;
import com.buen.orden.payments.apiBuenOrden.model.Discipline;
import com.buen.orden.payments.apiBuenOrden.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<DisciplineDTO> getDisciplines(){
        return disciplineRepository.findAll().stream()
                .map(DisciplineMapper::toDTO)
                .toList();
    }

    public Optional<DisciplineDTO> getDisciplineByID(Long id){
        return disciplineRepository.findById(id).map(DisciplineMapper::toDTO);
    }

    public DisciplineDTO createDiscipline(DisciplineDTO dto){
        Discipline d = DisciplineMapper.toEntity(dto);
        Discipline saved = disciplineRepository.save(d);
        return DisciplineMapper.toDTO(saved);
    }

    public DisciplineDTO updateDiscipline(Long id, DisciplineDTO dto){
        return disciplineRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    Discipline updated = disciplineRepository.save(existing);
                    return DisciplineMapper.toDTO(updated);
                })
                .orElseThrow(() -> new RuntimeException("Discipline not found with id " + id));
    }

    public void deleteDiscipline(Long id){
        disciplineRepository.deleteById(id);
    }
}
