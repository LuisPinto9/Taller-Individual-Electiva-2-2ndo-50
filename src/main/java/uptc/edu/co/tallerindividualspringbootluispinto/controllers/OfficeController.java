package uptc.edu.co.tallerindividualspringbootluispinto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Medic;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Office;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Specialization;
import uptc.edu.co.tallerindividualspringbootluispinto.response.ResponseHandler;
import uptc.edu.co.tallerindividualspringbootluispinto.services.MedicService;
import uptc.edu.co.tallerindividualspringbootluispinto.services.OfficeService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @Autowired
    private MedicService medicService;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        try {
            List<Office> list = officeService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@RequestParam("id") Integer id) {
        try {
            if (officeService.findById(id) != null) {
                return ResponseHandler.generateResponse("Succes", HttpStatus.OK, officeService.findById(id));
            } else {
                return ResponseHandler.generateResponse("Succes", HttpStatus.NOT_FOUND, officeService.findById(id));
            }
        } catch (Error e) {
            return ResponseHandler.generateResponse("Succes", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save(@RequestBody Office specialization, @PathVariable Integer id) {
        try {
            Medic medic = medicService.findById(id);
            if (medic != null) {
                Office result = officeService.save(specialization, medic);
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
            Office specialization = officeService.findById(id);
            if (specialization != null) {
                officeService.delete(specialization);
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, specialization);
            } else {
                return ResponseHandler.generateResponse("Succes", HttpStatus.NOT_FOUND, null);
            }
        } catch (Error e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Office office) {
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, officeService.update(id, office));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }
}
