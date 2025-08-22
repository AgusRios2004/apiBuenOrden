package com.buen.orden.payments.apiBuenOrden.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Role role;
}