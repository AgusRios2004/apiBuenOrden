package com.buen.orden.payments.apiBuenOrden.repository;

import com.buen.orden.payments.apiBuenOrden.model.MonthlyPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyPaymentRepository extends JpaRepository<MonthlyPayment, Long> {
}