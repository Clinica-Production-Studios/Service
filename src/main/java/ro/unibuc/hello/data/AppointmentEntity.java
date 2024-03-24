package ro.unibuc.hello.data;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class AppointmentEntity {
    @Id
    public String id;
    public AppointmentIntervalEntity appointmentInterval;
    public DoctorEntity doctor;
    public PatientEntity patient;
    public LocalDate date;

    public AppointmentEntity() {
    }

    public AppointmentEntity(AppointmentIntervalEntity appointmentInterval, DoctorEntity doctor, PatientEntity patient, LocalDate date) {
        this.appointmentInterval = appointmentInterval;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format(
                "Appointment[id='%s', appointmentInterval='%s', doctor='%s', patient='%s', date='%s']",
                id, appointmentInterval.toString(), doctor.toString(), patient.toString(), date.toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AppointmentIntervalEntity getAppointmentInterval() {
        return appointmentInterval;
    }

    public void setAppointmentInterval(AppointmentIntervalEntity appointmentInterval) {
        this.appointmentInterval = appointmentInterval;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
