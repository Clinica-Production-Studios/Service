package ro.unibuc.hello.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.unibuc.hello.data.AppointmentEntity;
import ro.unibuc.hello.data.AppointmentRepository;
import ro.unibuc.hello.exception.EntityNotFoundException;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentEntity createAppointment(AppointmentEntity appointment) {
        appointment.setId(null);
        appointmentRepository.save(appointment);
        return appointment;
    }

    public AppointmentEntity getAppointmentById(String id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("appointment"));
    }

    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public AppointmentEntity updateAppointment(AppointmentEntity appointment) {
        appointmentRepository.findById(appointment.getId())
                .orElseThrow(() -> new EntityNotFoundException("appointment"));
        appointmentRepository.save(appointment);
        return appointment;
    }

    public void deleteAppointment(String id) {
        AppointmentEntity appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("appointment"));
        appointmentRepository.delete(appointment);
    }

    public List<AppointmentEntity> getAppointmentsOfDoctor(String doctorId) {
        return appointmentRepository.findAllAppointmentsOfDoctor(doctorId);
    }

    public List<AppointmentEntity> getAppointmentsOfPatient(String patientId) {
        return appointmentRepository.findAllAppointmentsOfPatient(patientId);
    }

    public List<AppointmentEntity> getAppointmentsOfDoctorWithinDateRange(String doctorId, LocalDate startDate,
            LocalDate endDate) {
        return appointmentRepository.findAppointmentsOfDoctorWithinDateRange(doctorId, startDate, endDate);
    }

    public List<AppointmentEntity> getAppointmentsOfPatientWithinDateRange(String patientId, LocalDate startDate,
            LocalDate endDate) {
        return appointmentRepository.findAppointmentsOfPatientWithinDateRange(patientId, startDate, endDate);
    }
}
