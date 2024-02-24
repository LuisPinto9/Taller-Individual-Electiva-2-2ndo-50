package uptc.edu.co.tallerindividualspringbootluispinto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Medic;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Patient;
import uptc.edu.co.tallerindividualspringbootluispinto.response.ResponseHandler;
import uptc.edu.co.tallerindividualspringbootluispinto.services.MedicService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/medics")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<Medic> list = medicService.findAll();
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@RequestParam("id") Integer id) {
        try {
            if (medicService.findById(id) != null) {
                return ResponseHandler.generateResponse("Succes", HttpStatus.OK, medicService.findById(id));
            } else {
                return ResponseHandler.generateResponse("No se encuentra", HttpStatus.NOT_FOUND, medicService.findById(id));
            }
        } catch (Error e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping(value = "/patients/{id}")
    public ResponseEntity<Object> getPatients(@RequestParam("id") Integer id) {
        try {
            if (medicService.findById(id) != null) {
                return ResponseHandler.generateResponse("Succes", HttpStatus.OK, medicService.getPatients(medicService.findById(id)));
            } else {
                return ResponseHandler.generateResponse("No se encuentra", HttpStatus.NOT_FOUND, medicService.findById(id));
            }
        } catch (Error e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody Medic medic) {
        try {
            Medic result = medicService.save(medic);
            return ResponseHandler.generateResponse("Succes", HttpStatus.OK, result);
        } catch (Error e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        Medic medic = medicService.findById(id);
        if (medic != null) {
            medicService.delete(medic);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, medic);
        } else {
            return ResponseHandler.generateResponse("Succes", HttpStatus.NOT_FOUND, null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Medic updatedMedic) {
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, medicService.update(id, updatedMedic));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }
}
