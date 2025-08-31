package com.buen.orden.payments.apiBuenOrden.dto.request;

import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlayerCategoryHistoryRequestDTO {
    private String description;
    private LocalDate dateSince;
    private LocalDate dateUntil;
}
