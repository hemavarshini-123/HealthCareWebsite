package crud.healthcare.Service;

import crud.healthcare.Model.Appointment;
import crud.healthcare.Model.AppointmentStatus;
import crud.healthcare.Model.ConfirmedAppointment;
import crud.healthcare.Repo.AppointmentRepository;
import crud.healthcare.Repo.ConfirmedAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ConfirmedAppointmentService {

    @Autowired
    private ConfirmedAppointmentRepository confirmedRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;


    public ConfirmedAppointment confirmAppointment(Long appointmentId,
                                                   LocalTime time) {

        Appointment appt = appointmentRepo.findById(appointmentId)
                .orElseThrow(()-> new RuntimeException("Appointment not found"));


        appt.setStatus(AppointmentStatus.APPROVED);
        appointmentRepo.save(appt);

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
