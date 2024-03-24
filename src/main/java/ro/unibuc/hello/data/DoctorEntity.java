package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;

public class DoctorEntity {
    @Id
    public String id;
    public String name;
    public String specialization;

    public DoctorEntity() {
    }

    public DoctorEntity(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return String.format(
                "Doctor[id=%s, name='%s', specialization='%s']",
                id, name, specialization);
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
}
