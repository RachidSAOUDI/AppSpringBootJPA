package ma.usmba.appspringbootjpa.repositories;

import ma.usmba.appspringbootjpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
