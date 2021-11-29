package com.zekerijah.eventdemo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventReq {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private PeriodDto period;

    @Override
    public String toString() {
        return "CreateEventReq{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", period=" + period +
                '}';
    }
}