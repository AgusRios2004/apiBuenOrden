package com.buen.orden.payments.apiBuenOrden.service;

import com.buen.orden.payments.apiBuenOrden.dto.request.StateRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.StateResponseDTO;
import com.buen.orden.payments.apiBuenOrden.mappers.StateMapper;
import com.buen.orden.payments.apiBuenOrden.model.State;
import com.buen.orden.payments.apiBuenOrden.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public StateResponseDTO create(StateRequestDTO dto) {
        State state = new State();
        state.setName(dto.getName());
        State saved = stateRepository.save(state);
        return StateMapper.toDTO(saved);
    }

    public List<StateResponseDTO> getAll() {
        return stateRepository.findAll()
                .stream()
                .map(StateMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StateResponseDTO getById(Long id) {
        State state = stateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found"));
        return StateMapper.toDTO(state);
    }

    public StateResponseDTO update(Long id, StateRequestDTO dto) {
        State state = stateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found"));

        state.setName(dto.getName());
        return StateMapper.toDTO(stateRepository.save(state));
    }

    public void delete(Long id) {
        stateRepository.deleteById(id);
    }
}
