package com.buen.orden.payments.apiBuenOrden.repository;

import com.buen.orden.payments.apiBuenOrden.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {
}