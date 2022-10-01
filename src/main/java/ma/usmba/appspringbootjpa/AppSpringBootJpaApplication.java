package ma.usmba.appspringbootjpa;

import ma.usmba.appspringbootjpa.entities.Patient;
import ma.usmba.appspringbootjpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class AppSpringBootJpaApplication implements CommandLineRunner {
    @Autowired //injection de dependence
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(AppSpringBootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null, "Hassan", new Date(), true, 56));
        patientRepository.save(new Patient(null, "Mohammed", new Date(), false, 97));
        patientRepository.save(new Patient(null, "Imane", new Date(), false, 210));


    }
}
