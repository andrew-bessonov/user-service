package ru.bessik.userservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bessik.userservice.controller.dto.FioDto;
import ru.bessik.userservice.controller.dto.UserRequestDto;
import ru.bessik.userservice.controller.dto.UserResponseDto;
import ru.bessik.userservice.entity.User;
import ru.bessik.userservice.repository.ClientRepository;
import ru.bessik.userservice.utils.UserMapper;

import java.util.List;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final ClientRepository repository;

    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = UserMapper.toEntity(userRequestDto);
        User savedUser = repository.save(user);
        log.info("success saved {}", savedUser);
        return UserMapper.toResponse(savedUser);
    }

    public List<FioDto> getFioList() {
        Iterable<User> users = repository.findAll();
        log.info("find users {}", users);
        List<FioDto> list = StreamSupport.stream(users.spliterator(), false)
                .map(it -> new FioDto(it.getName(), it.getLastName()))
                .toList();
        log.info("mapping to fio {}", list);
        return list;
    }

    public FioDto getFio(Long userId) {
        User user = repository.findById(userId)
                .orElseThrow();
        log.info("find user {}", user);
        FioDto dto = FioDto.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .build();
        log.info("mapping to {}", dto);
        return dto;
    }
}
