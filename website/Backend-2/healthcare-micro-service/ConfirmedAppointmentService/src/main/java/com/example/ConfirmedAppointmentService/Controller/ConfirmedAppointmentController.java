package com.example.ConfirmedAppointmentService.Controller;


import com.example.ConfirmedAppointmentService.Model.ConfirmedAppointment;
import com.example.ConfirmedAppointmentService.Service.ConfirmedAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
@RequestMapping("/confirmed")
public class ConfirmedAppointmentController {
    @Autowired
    private ConfirmedAppointmentService service;

    @PostMapping("/{id}")
    public ConfirmedAppointment confirmAppointment(
            @PathVariable Long id,
            @RequestBody ConfirmedAppointment request) {

        return service.confirmAppointment(id, request.getAppointmentTime());
    }

    @GetMapping
    public List<ConfirmedAppointment> getConfirmedAppointments(
            @RequestParam String email) {

        return service.getConfirmedAppointments(email);
    }

}
