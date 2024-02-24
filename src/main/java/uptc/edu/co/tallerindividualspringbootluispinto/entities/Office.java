package uptc.edu.co.tallerindividualspringbootluispinto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "offices")
public class Office implements Serializable {

    public Office() {
    }

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdOffice;

    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20, name = "addres")
    private String address;
    @Column(nullable = false, length = 20, name = "floor")
    private String floor;

    @OneToOne
    @JsonIgnore
    private Medic medic;

    public Integer getIdOffice() {
        return IdOffice;
    }

    public void setIdOffice(Integer idOffice) {
        IdOffice = idOffice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }
}
