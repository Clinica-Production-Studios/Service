package ro.unibuc.hello.dto;

import javax.validation.constraints.NotBlank;

public class Patient {
    private String id;
    @NotBlank
    private String name;

    public Patient() {
    }

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
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
