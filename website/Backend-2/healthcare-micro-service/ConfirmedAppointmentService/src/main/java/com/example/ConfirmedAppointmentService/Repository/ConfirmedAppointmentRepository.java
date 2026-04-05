package com.example.ConfirmedAppointmentService.Repository;

import com.example.ConfirmedAppointmentService.Model.ConfirmedAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ConfirmedAppointmentRepository
        extends JpaRepository<ConfirmedAppointment, Long> {

    List<ConfirmedAppointment> findByEmail(String email);
}
