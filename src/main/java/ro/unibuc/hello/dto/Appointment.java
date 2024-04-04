package ro.unibuc.hello.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Appointment {
    private String id;
    @Valid
    private AppointmentInterval appointmentInterval;
    @Valid
    private Doctor doctor;
    @Valid
    private Patient patient;
    @NotNull
    private LocalDate date;

    public Appointment() {
    }

    public Appointment(String id, AppointmentInterval appointmentInterval, Doctor doctor, Patient patient,
            LocalDate date) {
        this.id = id;
        this.appointmentInterval = appointmentInterval;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AppointmentInterval getAppointmentInterval() {
        return appointmentInterval;
    }

    public void setAppointmentInterval(AppointmentInterval appointmentInterval) {
        this.appointmentInterval = appointmentInterval;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
