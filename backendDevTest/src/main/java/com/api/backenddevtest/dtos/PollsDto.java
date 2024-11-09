package com.api.backenddevtest.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PollsDto {
    private String name;

    private List<OptionDto> optionDtos= new ArrayList<>();
}
