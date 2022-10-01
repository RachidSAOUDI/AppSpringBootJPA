package ma.usmba.appspringbootjpa.repositories;

import ma.usmba.appspringbootjpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> findByMalade(boolean m);

}
