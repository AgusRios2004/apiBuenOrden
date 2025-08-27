package com.buen.orden.payments.apiBuenOrden.repository;

import com.buen.orden.payments.apiBuenOrden.model.TeacherCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherCategoryRepository extends JpaRepository<TeacherCategory, Long> {
}