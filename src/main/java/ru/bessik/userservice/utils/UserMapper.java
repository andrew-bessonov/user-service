package ru.bessik.userservice.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.bessik.userservice.controller.dto.UserRequestDto;
import ru.bessik.userservice.controller.dto.UserResponseDto;
import ru.bessik.userservice.entity.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {
    public static User toEntity(UserRequestDto requestDto) {
        return User.builder()
                .name(requestDto.getName())
                .lastName(requestDto.getLastName())
                .age(requestDto.getAge())
                .phoneNumber(requestDto.getPhoneNumber())
                .telegramId(requestDto.getTelegramId())
                .build();
    }

    public static UserResponseDto toResponse(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .phoneNumber(user.getPhoneNumber())
                .telegramId(user.getTelegramId())
                .build();
    }
}
