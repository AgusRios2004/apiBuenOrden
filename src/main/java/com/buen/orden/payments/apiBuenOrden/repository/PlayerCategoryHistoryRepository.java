package com.buen.orden.payments.apiBuenOrden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerCategoryHistoryRepository extends JpaRepository<PlayerCategoryHistoryRepository, Long> {
}