package ru.bessik.userservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    /**
     * id
     */
    private Long id;

    /**
     * telegram
     */
    private Long telegramId;

    /**
     * Имя
     */
    private String name;

    /**
     * Фамилия
     */
    private String lastName;

    /**
     * Возраст
     */
    private Integer age;

    /**
     * Номер телефона
     */
    private String phoneNumber;
}
