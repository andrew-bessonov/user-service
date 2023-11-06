package ru.bessik.userservice.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseDto {
    private String status;
    private List<FioDto> listFio;
}
