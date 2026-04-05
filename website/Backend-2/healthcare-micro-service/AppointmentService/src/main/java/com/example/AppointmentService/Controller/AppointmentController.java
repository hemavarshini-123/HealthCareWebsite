package com.example.AppointmentService.Controller;


import com.example.AppointmentService.Model.Appointment;
import com.example.AppointmentService.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService service;

    @PostMapping
    public Appointment bookAppointment( @RequestBody Appointment appt) {
        return service.bookAppointment(appt);
    }
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return service.getAppointmentById(id);
    }

    @GetMapping("/patient")
    public List<Appointment> getPatientAppointments(@RequestParam String email) {
        return service.getAppointmentsByPatient(email);
    }

    @GetMapping("/pending")
    public List<Appointment> getPendingAppointments() {
        return service.getPendingAppointments();
    }

    @PutMapping("/{id}/approve")
    public Appointment approve(@PathVariable Long id) {
        return service.approveAppointment(id);
    }

    @PutMapping("/{id}/reject")
    public Appointment reject(@PathVariable Long id) {
        return service.rejectAppointment(id);
    }

    @GetMapping
    public List<Appointment> getAll() {
        return service.getAllAppointments();
    }


}
