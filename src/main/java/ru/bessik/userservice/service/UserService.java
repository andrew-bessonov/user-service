package ru.bessik.userservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bessik.userservice.controller.dto.UserRequestDto;
import ru.bessik.userservice.controller.dto.UserResponseDto;
import ru.bessik.userservice.entity.User;
import ru.bessik.userservice.repository.ClientRepository;
import ru.bessik.userservice.utils.UserMapper;

import java.util.ArrayList;
import java.util.List;

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

    public UserResponseDto find(Long userId) {
        User user = repository.findById(userId).orElseThrow(IllegalArgumentException::new);
        log.info("find user {}", user);
        return UserMapper.toResponse(user);
    }

    public List<UserResponseDto> findAll() {
        List<UserResponseDto> result = new ArrayList<>();
        repository.findAll()
                .forEach(it -> result.add(UserMapper.toResponse(it)));
        return result;
    }

    public void delete(Long userId) {
        repository.deleteById(userId);
        log.info("success deleted user by id = {}", userId);
    }
}
