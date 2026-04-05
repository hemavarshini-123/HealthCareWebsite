package crud.healthcare.Repo;

import crud.healthcare.Model.ConfirmedAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfirmedAppointmentRepository
        extends JpaRepository<ConfirmedAppointment, Long> {

    List<ConfirmedAppointment> findByEmail(String email);
}

