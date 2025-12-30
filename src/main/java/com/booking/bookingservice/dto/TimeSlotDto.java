package com.booking.bookingservice.dto;

public record TimeSlotDto(
        String startTime,
        String endTime,
        boolean available
) {}
