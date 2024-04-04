package ro.unibuc.hello.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DoctorPatients {
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String specialization;
    @NotNull
    private List<Patient> patients;

    public DoctorPatients() {
    }

    public DoctorPatients(String id, String name, String specialization, List<Patient> patients) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.patients = patients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

}
