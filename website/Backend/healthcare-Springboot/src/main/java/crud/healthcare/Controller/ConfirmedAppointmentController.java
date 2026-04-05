package crud.healthcare.Controller;

import crud.healthcare.Model.ConfirmedAppointment;
import crud.healthcare.Service.ConfirmedAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/confirmed")
@CrossOrigin(origins = "http://localhost:5173")
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

