package uptc.edu.co.tallerindividualspringbootluispinto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Medic;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Office;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Patient;
import uptc.edu.co.tallerindividualspringbootluispinto.repositories.OfficeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {
    @Autowired
    OfficeRepository officeRepository;

    public List<Office> findAll() {
        return officeRepository.findAll();
    }

    public Office findById(Integer id) {
        Optional<Office> optional = officeRepository.findById(id);
        return optional.orElse(null);
    }

    public Office save(Office office, Medic medic) {
        office.setMedic(medic);
        return officeRepository.save(office);
    }

    public Office update(Integer id, Office Office) {
        Office OfficeFound = findById(id);
        OfficeFound.setName(Office.getName());
        OfficeFound.setAddress(Office.getAddress());
        OfficeFound.setFloor(Office.getFloor());
        OfficeFound.setMedic(Office.getMedic());
        officeRepository.save(OfficeFound);
        return findById(id);
    }

    public void delete(Office office) {
        officeRepository.delete(office);
    }

}
