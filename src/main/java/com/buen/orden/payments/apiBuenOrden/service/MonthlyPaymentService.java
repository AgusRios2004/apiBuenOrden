package com.buen.orden.payments.apiBuenOrden.service;

import com.buen.orden.payments.apiBuenOrden.dto.request.MonthlyPaymentRequestDTO;
import com.buen.orden.payments.apiBuenOrden.dto.response.MonthlyPaymentResponseDTO;
import com.buen.orden.payments.apiBuenOrden.mappers.MonthlyPaymentMapper;
import com.buen.orden.payments.apiBuenOrden.model.MonthlyPayment;
import com.buen.orden.payments.apiBuenOrden.model.Player;
import com.buen.orden.payments.apiBuenOrden.repository.MonthlyPaymentRepository;
import com.buen.orden.payments.apiBuenOrden.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonthlyPaymentService {

    @Autowired
    private MonthlyPaymentRepository repository;
    @Autowired
    private PlayerRepository playerRepository;

    public MonthlyPaymentResponseDTO create(MonthlyPaymentRequestDTO dto) {
        Player player = playerRepository.findById(dto.getPlayerId())
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));

        MonthlyPayment payment = MonthlyPaymentMapper.toEntity(dto, player);
        return MonthlyPaymentMapper.toResponseDTO(repository.save(payment));
    }

    public List<MonthlyPaymentResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(MonthlyPaymentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public MonthlyPaymentResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(MonthlyPaymentMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
