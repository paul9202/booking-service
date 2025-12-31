package com.booking.bookingservice.controller;

import com.booking.bookingservice.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BookingController {

    @GetMapping("/services")
    public List<ServiceTypeDto> services() {
        return List.of(
                new ServiceTypeDto("PET_GROOMING", "Pet Grooming", "Pet bathing", 60),
                new ServiceTypeDto("FACIAL", "Facial Massage", "Facial service", 60),
                new ServiceTypeDto("BADMINTON", "Badminton Court", "Court booking", 60)
        );
    }

    @GetMapping("/resources")
    public List<ResourceDto> resources(@RequestParam String serviceTypeId) {
        return List.of(
                new ResourceDto("RES-001", "Alice", serviceTypeId),
                new ResourceDto("RES-002", "Bob", serviceTypeId)
        );
    }

    @GetMapping("/timeslots")
    public List<TimeSlotDto> timeSlots(
            @RequestParam String resourceId,
            @RequestParam String date
    ) {
        return List.of(
                new TimeSlotDto("09:00", "10:00", true),
                new TimeSlotDto("10:00", "11:00", false)
        );
    }

    @PostMapping("/bookings")
    public BookingResponse create(@RequestBody CreateBookingRequest request) {
        return new BookingResponse("BK-" + System.currentTimeMillis(), "CONFIRMED");
    }

    @GetMapping("/bookings")
    public List<Map<String, Object>> myBookings(@RequestParam String userId) {
        return List.of(
                Map.of(
                        "bookingId", "BK-10001",
                        "serviceTypeName", "Pet Grooming",
                        "resourceName", "Alice",
                        "date", "2025-01-20",
                        "startTime", "09:00",
                        "endTime", "10:00",
                        "status", "CONFIRMED"
                )
        );
    }

    @DeleteMapping("/bookings/{id}")
    public Map<String, String> cancel(@PathVariable String id) {
        return Map.of("status", "CANCELLED");
    }
}
