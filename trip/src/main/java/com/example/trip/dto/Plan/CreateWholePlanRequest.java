package com.example.trip.dto.Plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data @AllArgsConstructor
@Builder
public class CreateWholePlanRequest {

    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<PlanDay> planDays;

}
