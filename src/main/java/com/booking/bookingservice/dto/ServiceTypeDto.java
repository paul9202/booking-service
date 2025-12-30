package com.booking.bookingservice.dto;

public record ServiceTypeDto(
        String id,
        String name,
        String description,
        int durationMinutes
) {}
