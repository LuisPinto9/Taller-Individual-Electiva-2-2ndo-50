package uptc.edu.co.tallerindividualspringbootluispinto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Medic;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Specialization;
import uptc.edu.co.tallerindividualspringbootluispinto.response.ResponseHandler;
import uptc.edu.co.tallerindividualspringbootluispinto.services.MedicService;
import uptc.edu.co.tallerindividualspringbootluispinto.services.SpecializationService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/specailization")
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private MedicService medicService;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        try {
            List<Specialization> list = specializationService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@RequestParam("id") Integer id) {
        try {
            if (specializationService.findById(id) != null) {
                return ResponseHandler.generateResponse("Succes", HttpStatus.OK, specializationService.findById(id));
            } else {
                return ResponseHandler.generateResponse("Succes", HttpStatus.NOT_FOUND, specializationService.findById(id));
            }
        } catch (Error e) {
            return ResponseHandler.generateResponse("Succes", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save(@RequestBody Specialization specialization, @PathVariable Integer id) {
        try {
            Medic medic = medicService.findById(id);
            if (medic != null) {
                Specialization result = specializationService.save(specialization, medic);
                return ResponseHandler.generateResponse("Succes", HttpStatus.OK, result);
            } else {
                return ResponseHandler.generateResponse("Succes", HttpStatus.NOT_FOUND, null);
            }
        } catch (Error e) {
            return ResponseHandler.generateResponse("Succes", HttpStatus.INTERNAL_SERVER_ERROR, e);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Specialization specialization = specializationService.findById(id);
            if (specialization != null) {
                specializationService.delete(specialization);
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, specialization);
            } else {
                return ResponseHandler.generateResponse("Succes", HttpStatus.NOT_FOUND, null);
            }
        } catch (Error e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Specialization updatedSpecialization) {
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, specializationService.update(id, updatedSpecialization));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }
}
