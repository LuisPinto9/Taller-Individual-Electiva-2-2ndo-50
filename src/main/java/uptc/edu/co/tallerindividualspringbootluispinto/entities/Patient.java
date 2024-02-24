package uptc.edu.co.tallerindividualspringbootluispinto.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient implements Serializable {

    public Patient() {
        medics = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdPatient;

    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20, name = "lastname")
    private String lastname;

    @ManyToMany(mappedBy = "patients", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Medic> medics;

    public Integer getIdPatient() {
        return IdPatient;
    }

    public void setIdPatient(Integer idPatient) {
        IdPatient = idPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Medic> getMedics() {
        return medics;
    }

    public void setMedics(List<Medic> medics) {
        this.medics = medics;
    }

}
