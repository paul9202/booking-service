package com.booking.bookingservice.dto;

public record CreateBookingRequest(
        String userId,
        String serviceTypeId,
        String resourceId,
        String date,
        String startTime,
        String endTime
) {}
