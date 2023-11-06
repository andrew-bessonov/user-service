package ru.bessik.userservice.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "USERS")
public class User {
    /**
     * id
     */
    @Id
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
