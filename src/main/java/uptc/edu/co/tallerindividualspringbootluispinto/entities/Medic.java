package uptc.edu.co.tallerindividualspringbootluispinto.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medics")
public class Medic implements Serializable {

    public Medic() {
        patients = new ArrayList<>();
        specializations = new ArrayList<>();
    }

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdMedic;

    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20, name = "lastname")
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "medics_patients",
            joinColumns = @JoinColumn(name = "idMedic"),
            inverseJoinColumns = @JoinColumn(name = "idPatient")
    )
    private List<Patient> patients;

    @OneToMany(mappedBy = "medic", cascade = CascadeType.REMOVE)
    private List<Specialization> specializations;

    @OneToOne(mappedBy = "medic", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "idOffice")
    private Office office;

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Integer getIdMedic() {
        return IdMedic;
    }

    public void setIdMedic(Integer idMedic) {
        IdMedic = idMedic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
