package com.buen.orden.payments.apiBuenOrden.repository;

import com.buen.orden.payments.apiBuenOrden.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
