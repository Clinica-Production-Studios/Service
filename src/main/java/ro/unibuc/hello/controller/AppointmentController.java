package ro.unibuc.hello.controller;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.unibuc.hello.data.AppointmentEntity;
import ro.unibuc.hello.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public AppointmentEntity createAppointment(@RequestBody AppointmentEntity appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/{id}")
    public AppointmentEntity getAppointmentById(@PathVariable String id) {
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping
    public List<AppointmentEntity> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PutMapping("/{id}")
    public AppointmentEntity updateAppointment(@PathVariable String id, @RequestBody AppointmentEntity appointment) {
        appointment.setId(id);
        return appointmentService.updateAppointment(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable String id) {
        appointmentService.deleteAppointment(id);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<AppointmentEntity> getAppointmentsOfDoctor(@PathVariable String doctorId) {
        return appointmentService.getAppointmentsOfDoctor(doctorId);
    }

    @GetMapping("/patient/{patientId}")
    public List<AppointmentEntity> getAppointmentsOfPatient(@PathVariable String patientId) {
        return appointmentService.getAppointmentsOfPatient(patientId);
    }

    @GetMapping("/doctor/{doctorId}/date-range")
    public List<AppointmentEntity> getAppointmentsOfDoctorWithinDateRange(@PathVariable String doctorId,
                                                                         @RequestParam LocalDate startDate,
                                                                         @RequestParam LocalDate endDate) {
        return appointmentService.getAppointmentsOfDoctorWithinDateRange(doctorId, startDate, endDate);
    }

    @GetMapping("/patient/{patientId}/date-range")
    public List<AppointmentEntity> getAppointmentsOfPatientWithinDateRange(@PathVariable String patientId,
                                                                         @RequestParam LocalDate startDate,
                                                                         @RequestParam LocalDate endDate) {
        return appointmentService.getAppointmentsOfPatientWithinDateRange(patientId, startDate, endDate);
    }

}
