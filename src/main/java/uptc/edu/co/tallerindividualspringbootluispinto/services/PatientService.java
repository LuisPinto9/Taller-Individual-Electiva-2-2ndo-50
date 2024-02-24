package uptc.edu.co.tallerindividualspringbootluispinto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Medic;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Patient;
import uptc.edu.co.tallerindividualspringbootluispinto.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findById(Integer id) {
        Optional<Patient> optional = patientRepository.findById(id);
        return optional.orElse(null);
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient update(Integer id, Patient patient) {
        Patient patientFound = findById(id);
        patientFound.setName(patient.getName());
        patientFound.setLastname(patient.getLastname());
        patientRepository.save(patientFound);
        return patientFound;
    }

    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }
}
