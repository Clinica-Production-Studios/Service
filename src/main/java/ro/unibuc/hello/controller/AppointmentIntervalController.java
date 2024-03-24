package ro.unibuc.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.unibuc.hello.data.AppointmentIntervalEntity;
import ro.unibuc.hello.service.AppointmentIntervalService;

@RestController
@RequestMapping("/appointmentInterval")
public class AppointmentIntervalController {
    @Autowired
    private AppointmentIntervalService appointmentIntervalService;

    @PostMapping
    public AppointmentIntervalEntity createAppointmentInterval(@RequestBody AppointmentIntervalEntity appointmentInterval) {
        return appointmentIntervalService.createAppointmentInterval(appointmentInterval);
    }

    @GetMapping("/{id}")
    public AppointmentIntervalEntity getAppointmentIntervalById(@PathVariable String id) {
        return appointmentIntervalService.getAppointmentIntervalById(id);
    }

    @GetMapping
    public List<AppointmentIntervalEntity> getAllAppointmentIntervals() {
        return appointmentIntervalService.getAllAppointmentIntervals();
    }

    @PutMapping("/{id}")
    public AppointmentIntervalEntity updateAppointmentInterval(@PathVariable String id, @RequestBody AppointmentIntervalEntity appointmentInterval) {
        appointmentInterval.setId(id);
        return appointmentIntervalService.updateAppointmentInterval(appointmentInterval);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointmentInterval(@PathVariable String id) {
        appointmentIntervalService.deleteAppointmentInterval(id);
    }
}
