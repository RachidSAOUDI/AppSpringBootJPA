package ma.usmba.appspringbootjpa;

import ma.usmba.appspringbootjpa.entities.Patient;
import ma.usmba.appspringbootjpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AppSpringBootJpaApplication implements CommandLineRunner {
    @Autowired //injection de dependence
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(AppSpringBootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<100; i++){
            patientRepository.save(new Patient(null, "Hassan", new Date(), true, (int)(Math.random()*100)));
        }

        Page<Patient> patiens = patientRepository.findAll(PageRequest.of(1, 5));
        System.out.println("Total Pages : "+patiens.getTotalPages());
        System.out.println("Total Elements : "+patiens.getTotalElements());
        System.out.println("Number of page : "+patiens.getNumber());
        List<Patient> content = patiens.getContent();
        content.forEach(p->{
            System.out.println("============================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
        });
        System.out.println("***********************************");
        Patient patient = patientRepository.findById(1L).orElse(null);// L for type Long Or use "new Long(1)"
        if (patient != null){
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        patient.setScore(870);
        patientRepository.save(patient);
        patientRepository.deleteById(1L);

    }
}
