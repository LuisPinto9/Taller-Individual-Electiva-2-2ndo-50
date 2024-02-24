package uptc.edu.co.tallerindividualspringbootluispinto.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "specializations")
public class Specialization implements Serializable {

    public Specialization() {
    }

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdSpecialization;

    @Column(nullable = false, length = 20)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_medic_specialization"))
    @JsonIgnore
    private Medic medic;

    public Integer getIdSpecialization() {
        return IdSpecialization;
    }

    public void setIdSpecialization(Integer idSpecialization) {
        IdSpecialization = idSpecialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }
}
