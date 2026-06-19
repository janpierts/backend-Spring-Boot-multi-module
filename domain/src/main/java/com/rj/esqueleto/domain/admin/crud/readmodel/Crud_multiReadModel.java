package com.rj.esqueleto.domain.admin.crud.readmodel;

import java.time.LocalDateTime;

public record Crud_multiReadModel(
    Long id,
    String name,
    String email,
    LocalDateTime created,
    LocalDateTime updated,
    Boolean state,
    Boolean isValid,
    String message) {
}
