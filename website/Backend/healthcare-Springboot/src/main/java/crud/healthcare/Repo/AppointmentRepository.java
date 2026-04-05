package crud.healthcare.Repo;

import crud.healthcare.Model.Appointment;
import crud.healthcare.Model.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByStatus(AppointmentStatus status);

    List<Appointment> findByEmail(String email);

}
