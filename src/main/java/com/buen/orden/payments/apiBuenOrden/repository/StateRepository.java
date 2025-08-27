package com.buen.orden.payments.apiBuenOrden.repository;

import com.buen.orden.payments.apiBuenOrden.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}