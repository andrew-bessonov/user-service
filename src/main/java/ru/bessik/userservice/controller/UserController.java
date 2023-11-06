package ru.bessik.userservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.bessik.userservice.controller.dto.UserRequestDto;
import ru.bessik.userservice.controller.dto.UserResponseDto;
import ru.bessik.userservice.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * Сохранить клиента
     *
     * @param userRequestDto данные клиента
     * @return сохраненная сущность
     */
    @PostMapping("/save")
    public UserResponseDto save(@RequestBody UserRequestDto userRequestDto) {
        log.info("[API] saveUser {}", userRequestDto);
        return userService.save(userRequestDto);
    }

    /**
     * Получить клиента по userId
     *
     * @param userId уникальный id клиента
     * @return сущность клиента
     */
    @GetMapping("/{userId}")
    public UserResponseDto find(@PathVariable Long userId) {
        log.info("[API] find user by userId = {}", userId);
        return userService.find(userId);
    }

    /**
     * Получить всех клиентов
     *
     * @return список всех клиентов
     */
    @GetMapping("/find-all")
    public List<UserResponseDto> findAll() {
        log.info("[API] find all users");
        return userService.findAll();
    }

    /**
     * Удалить клиента из базы
     *
     * @param userId уникальный id клиента
     */
    @DeleteMapping("/{userId}/delete")
    public void delete(@PathVariable Long userId) {
        log.info("[API] delete user with userId = {}", userId);
        userService.delete(userId);
    }
}
