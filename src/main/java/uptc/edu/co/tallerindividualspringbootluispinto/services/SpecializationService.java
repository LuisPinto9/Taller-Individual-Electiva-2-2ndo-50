package uptc.edu.co.tallerindividualspringbootluispinto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Medic;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Office;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Specialization;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Specialization;
import uptc.edu.co.tallerindividualspringbootluispinto.repositories.SpecializationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationService {
    @Autowired
    SpecializationRepository specializationRepository;

    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }

    public Specialization findById(Integer id) {
        Optional<Specialization> optional = specializationRepository.findById(id);
        return optional.orElse(null);
    }

    public Specialization save(Specialization specialization, Medic medic) {
        specialization.setMedic(medic);
        return specializationRepository.save(specialization);
    }

    public Specialization update(Integer id, Specialization Specialization) {
        Specialization SpecializationFound = findById(id);
        SpecializationFound.setName(Specialization.getName());
        specializationRepository.save(SpecializationFound);
        return SpecializationFound;
    }

    public void delete(Specialization specialization) {
        specializationRepository.delete(specialization);
    }
}
