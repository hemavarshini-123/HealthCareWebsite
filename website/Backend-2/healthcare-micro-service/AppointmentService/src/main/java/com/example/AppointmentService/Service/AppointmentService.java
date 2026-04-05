package com.example.AppointmentService.Service;



import com.example.AppointmentService.Model.Appointment;
import com.example.AppointmentService.Model.AppointmentStatus;
import com.example.AppointmentService.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repo;

    public Appointment bookAppointment(Appointment appt) {
        appt.setStatus(AppointmentStatus.PENDING);
        return repo.save(appt);
    }


    public List<Appointment> getPendingAppointments() {
        return repo.findByStatus(AppointmentStatus.PENDING);
    }

    public Appointment approveAppointment(Long id) {
        Appointment appt = repo.findById(id).orElseThrow();
        appt.setStatus(AppointmentStatus.APPROVED);
        return repo.save(appt);
    }

    public Appointment rejectAppointment(Long id) {
        Appointment appt = repo.findById(id).orElseThrow();
        appt.setStatus(AppointmentStatus.REJECTED);
        return repo.save(appt);
    }

    public List<Appointment> getAllAppointments() {
        return repo.findAll();
    }

    public List<Appointment> getAppointmentsByPatient(String email) {
        return repo.findByEmail(email);
    }
    public Appointment getAppointmentById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
