package com.buen.orden.payments.apiBuenOrden.mappers;

import com.buen.orden.payments.apiBuenOrden.dto.DisciplineDTO;
import com.buen.orden.payments.apiBuenOrden.model.Discipline;

public class DisciplineMapper {

    public static DisciplineDTO toDTO(Discipline d){
        if (d == null) return null;
        return new DisciplineDTO(d.getId(), d.getName());
    }

    public static Discipline toEntity(DisciplineDTO dto){
        if (dto == null) return null;
        Discipline d = new Discipline();
        d.setId(dto.getId());
        d.setName(dto.getName());
        return d;
    }
}
