package ro.unibuc.hello.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.unibuc.hello.dto.Appointment;
import ro.unibuc.hello.data.AppointmentEntity;
import ro.unibuc.hello.data.AppointmentRepository;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.mapper.AppointmentMapper;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        appointment.setId(null);
        AppointmentEntity appointmentEntity = appointmentRepository
                .save(AppointmentMapper.getInstance().toEntity(appointment));
        return appointment;
    }

    public Appointment getAppointmentById(String id) {
        return AppointmentMapper.getInstance().toDto(
                appointmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("appointment")));
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll().stream().map(AppointmentMapper.getInstance()::toDto)
                .collect(Collectors.toList());
    }

    public Appointment updateAppointment(Appointment appointment) {
        appointmentRepository.findById(appointment.getId())
                .orElseThrow(() -> new EntityNotFoundException("appointment"));
        AppointmentEntity appointmentEntity = appointmentRepository
                .save(AppointmentMapper.getInstance().toEntity(appointment));
        return AppointmentMapper.getInstance().toDto(appointmentEntity);
    }

    public void deleteAppointment(String id) {
        AppointmentEntity appointmentEntity = appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("appointment"));
        appointmentRepository.delete(appointmentEntity);
    }

    public List<Appointment> getAppointmentsOfDoctor(String doctorId) {
        return appointmentRepository.findAllAppointmentsOfDoctor(doctorId).stream()
                .map(AppointmentMapper.getInstance()::toDto).collect(Collectors.toList());
    }

    public List<Appointment> getAppointmentsOfPatient(String patientId) {
        return appointmentRepository.findAllAppointmentsOfPatient(patientId).stream()
                .map(AppointmentMapper.getInstance()::toDto).collect(Collectors.toList());
    }

    public List<Appointment> getAppointmentsOfDoctorWithinDateRange(String doctorId, LocalDate startDate,
            LocalDate endDate) {
        return appointmentRepository.findAppointmentsOfDoctorWithinDateRange(doctorId, startDate, endDate).stream()
                .map(AppointmentMapper.getInstance()::toDto).collect(Collectors.toList());
    }

    public List<Appointment> getAppointmentsOfPatientWithinDateRange(String patientId, LocalDate startDate,
            LocalDate endDate) {
        return appointmentRepository.findAppointmentsOfPatientWithinDateRange(patientId, startDate, endDate).stream()
                .map(AppointmentMapper.getInstance()::toDto).collect(Collectors.toList());
    }
}
