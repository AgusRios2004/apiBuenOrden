package com.buen.orden.payments.apiBuenOrden.dto.response;

import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlayerCategoryHistoryResponseDTO {
    private Long id;
    private String description;
    private LocalDate dateSince;
    private LocalDate dateUntil;
}
