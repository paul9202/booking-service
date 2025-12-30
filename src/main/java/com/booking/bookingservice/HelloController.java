package com.booking.bookingservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/health")
    public String health() {
        return "Booking Service is running";
    }
}