package ro.unibuc.hello.dto;

import java.util.List;

import ro.unibuc.hello.data.PatientEntity;

public class DoctorPatients {
    private String id;
    private String name;
    private String specialization;
    private List<PatientEntity> pacients;

    public DoctorPatients() {
    }

    public DoctorPatients(String id, String name, String specialization, List<PatientEntity> pacients) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.pacients = pacients;
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

    public List<PatientEntity> getPacients() {
        return pacients;
    }

    public void setPacients(List<PatientEntity> pacients) {
        this.pacients = pacients;
    }
}
