package crud.healthcare.Controller;

import crud.healthcare.Model.Appointment;
import crud.healthcare.Repo.AppointmentRepository;
import crud.healthcare.Service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController

@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public Appointment bookAppointment( @RequestBody Appointment appt) {
        return service.bookAppointment(appt);
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
