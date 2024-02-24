package uptc.edu.co.tallerindividualspringbootluispinto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Medic;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Office;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Patient;
import uptc.edu.co.tallerindividualspringbootluispinto.repositories.MedicRepository;
import uptc.edu.co.tallerindividualspringbootluispinto.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicService {

    @Autowired
    MedicRepository medicRepository;

    @Autowired
    PatientRepository patientRepository;

    public List<Medic> findAll() {
        return medicRepository.findAll();
    }

    public Medic findById(Integer id) {
        Optional<Medic> optional = medicRepository.findById(id);
        return optional.orElse(null);
    }

    public Medic save(Medic medic) {
        return medicRepository.save(medic);
    }

    public void delete(Medic medic) {
        medicRepository.delete(medic);
    }

    public Medic update(Integer id, Medic medic) {
        Medic medicFound = findById(id);
        medicFound.setName(medic.getName());
        medicFound.setLastName(medic.getLastName());
        medicRepository.save(medicFound);
        return medicFound;
    }

    public List<Patient> getPatients(Medic medic) {
        return patientRepository.findPatientByMedics(medic);
    }

}
