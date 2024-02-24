package uptc.edu.co.tallerindividualspringbootluispinto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Medic;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findPatientByMedics(Medic medic);
}
