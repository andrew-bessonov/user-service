package ru.bessik.userservice.controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bessik.userservice.controller.dto.FioDto;
import ru.bessik.userservice.controller.dto.ResponseDto;
import ru.bessik.userservice.controller.dto.UserRequestDto;
import ru.bessik.userservice.controller.dto.UserResponseDto;
import ru.bessik.userservice.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/save")
    public UserResponseDto saveUser(@RequestBody UserRequestDto userRequestDto) {
        log.info("[API] saveUser {}", userRequestDto);
        return userService.save(userRequestDto);
    }

    /**
     * Получить фамилию и имя клиента по id
     *
     * @param userId уникальный id клиента
     * @return Фамилию и имя клиента
     */
    @GetMapping("/user/{userId}")
    public FioDto getFio(@PathVariable Long userId) {
        log.info("[API] getFio {}", userId);
        return userService.getFio(userId);
    }

    /**
     * Получить фамилию и имя всех клиентов
     *
     * @return список с фамилией и именем всех клиентов
     */
    @GetMapping("/user/getAllFio")
    public ResponseDto getFioList() {
        log.info("[API] getFioList");
        List<FioDto> fioList = userService.getFioList();
        ResponseDto dto = ResponseDto.builder()
                .listFio(fioList)
                .status("OK")
                .build();
        log.error("ERROR");
        return dto;
    }

    /**
     * Получить фамилию и имя всех клиентов
     *
     * @return список с фамилией и именем всех клиентов
     */
    @GetMapping("/user/getAllFio")
    public ResponseDto getFioList2() {
        log.info("[API] getFioList");
        List<FioDto> fioList = userService.getFioList();
        ResponseDto dto = ResponseDto.builder()
                .listFio(fioList)
                .status("OK")
                .build();
        return dto;
    }
}
