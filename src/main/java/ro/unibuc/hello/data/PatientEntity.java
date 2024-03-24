package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;

public class PatientEntity {
    @Id
    public String id;
    public String name;

    public PatientEntity() {
    }

    public PatientEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Patient[id=%s, name='%s']",
                id, name);
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
}
