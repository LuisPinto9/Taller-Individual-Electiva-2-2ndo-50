package uptc.edu.co.tallerindividualspringbootluispinto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Medic;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Patient;
import uptc.edu.co.tallerindividualspringbootluispinto.response.ResponseHandler;
import uptc.edu.co.tallerindividualspringbootluispinto.services.MedicService;
import uptc.edu.co.tallerindividualspringbootluispinto.services.PatientService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private MedicService medicService;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        try {
            List<Patient> list = patientService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@RequestParam("id") Integer id) {
        try {
            if (patientService.findById(id) != null) {
                return ResponseHandler.generateResponse("Succes", HttpStatus.OK, patientService.findById(id));
            } else {
                return ResponseHandler.generateResponse("Succes", HttpStatus.NOT_FOUND, patientService.findById(id));
            }
        } catch (Error e) {
            return ResponseHandler.generateResponse("Succes", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody Patient patient) {
        try {
            return ResponseHandler.generateResponse("Succes", HttpStatus.OK, patientService.save(patient));
        } catch (Error e) {
            return ResponseHandler.generateResponse("Succes", HttpStatus.INTERNAL_SERVER_ERROR, e);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Patient patient = patientService.findById(id);
            if (patient != null) {
                patientService.delete(patient);
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, patient);
            } else {
                return ResponseHandler.generateResponse("Succes", HttpStatus.NOT_FOUND, null);
            }
        } catch (Error e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Patient updatedPatient) {
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, patientService.update(id, updatedPatient));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

}
