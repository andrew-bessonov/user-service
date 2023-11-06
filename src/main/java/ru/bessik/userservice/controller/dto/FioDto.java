package ru.bessik.userservice.controller.dto;

import lombok.*;

@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FioDto {
    /**
     * Имя
     */
    private String name;

    /**
     * Фамилия
     */
    private String lastName;
}
