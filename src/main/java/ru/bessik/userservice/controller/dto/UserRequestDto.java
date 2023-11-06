package ru.bessik.userservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
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
