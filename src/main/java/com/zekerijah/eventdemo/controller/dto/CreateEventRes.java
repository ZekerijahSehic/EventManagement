package com.zekerijah.eventdemo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateEventRes {
    private Long id;
    private String title;
    private String description;
    private PeriodDto period;
}
