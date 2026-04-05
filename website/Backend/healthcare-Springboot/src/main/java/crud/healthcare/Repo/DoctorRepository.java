package crud.healthcare.Repo;


import crud.healthcare.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    }


