package com.example.AppointmentService.Repository;

import com.example.AppointmentService.Model.Appointment;
import com.example.AppointmentService.Model.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    List<Appointment> findByStatus(AppointmentStatus appointmentStatus);

    List<Appointment> findByEmail(String email);
}
