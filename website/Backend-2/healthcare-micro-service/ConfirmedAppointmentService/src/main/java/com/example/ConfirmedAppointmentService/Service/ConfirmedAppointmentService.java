package com.example.ConfirmedAppointmentService.Service;

import com.example.AppointmentService.Model.Appointment;
import com.example.ConfirmedAppointmentService.Model.ConfirmedAppointment;
import com.example.ConfirmedAppointmentService.Repository.ConfirmedAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.util.List;

@Service
public class ConfirmedAppointmentService {

    @Autowired
    private ConfirmedAppointmentRepository confirmedRepo;

    @Autowired
    private RestTemplate restTemplate;

    public ConfirmedAppointment confirmAppointment(Long appointmentId, LocalTime time) {

        String url = "http://APPOINTMENTSERVICE/appointments/" + appointmentId;

        Appointment appt = restTemplate.getForObject(url, Appointment.class);

        ConfirmedAppointment confirmed = new ConfirmedAppointment();
        confirmed.setPatientName(appt.getPatientName());
        confirmed.setEmail(appt.getEmail());
        confirmed.setDoctorName(appt.getDoctorName());
        confirmed.setAppointmentDate(appt.getAppointmentDate());
        confirmed.setAppointmentTime(time);
        confirmed.setStatus("CONFIRMED");

        return confirmedRepo.save(confirmed);
    }

    public List<ConfirmedAppointment> getConfirmedAppointments(String email) {
        return confirmedRepo.findByEmail(email);
    }
}