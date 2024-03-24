package ro.unibuc.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import ro.unibuc.hello.data.PatientRepository;
import ro.unibuc.hello.data.DoctorEntity;
import ro.unibuc.hello.data.DoctorRepository;
import ro.unibuc.hello.data.AppointmentIntervalEntity;
import ro.unibuc.hello.data.AppointmentIntervalRepository;
import ro.unibuc.hello.data.PatientEntity;
import ro.unibuc.hello.data.AppointmentEntity;
import ro.unibuc.hello.data.AppointmentRepository;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = { DoctorRepository.class, AppointmentIntervalRepository.class, AppointmentRepository.class, PatientRepository.class})
public class HelloApplication {

	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private AppointmentIntervalRepository appointmentIntervalRepository;
	@Autowired
	private PatientRepository patientRepository;


	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	@PostConstruct
	public void runAfterObjectCreated() {
	
		doctorRepository.deleteAll();
		DoctorEntity doctor1 = new DoctorEntity("Gigel Andrei", "cardiolog");
		doctorRepository.save(doctor1);
		DoctorEntity doctor2 = new DoctorEntity("Ionel Barbu", "neurolog");
		doctorRepository.save(doctor2);
	
        appointmentIntervalRepository.deleteAll();
		AppointmentIntervalEntity appointmentInterval1 = new AppointmentIntervalEntity(8, 0);
		appointmentIntervalRepository.save(appointmentInterval1);
        AppointmentIntervalEntity appointmentInterval2 = new AppointmentIntervalEntity(9, 0);
        appointmentIntervalRepository.save(appointmentInterval2);

		patientRepository.deleteAll();
		PatientEntity patient1 = new PatientEntity("Bobita Stefan");
		patientRepository.save(patient1);
		PatientEntity patient2 = new PatientEntity("Marius Dragos");
		patientRepository.save(patient2);

		appointmentRepository.deleteAll();
        appointmentRepository.save(new AppointmentEntity(appointmentInterval1, doctor1, patient1, LocalDate.now().plusDays(10)));
        appointmentRepository.save(new AppointmentEntity(appointmentInterval2, doctor1, patient2, LocalDate.now().plusDays(12)));	
		appointmentRepository.save(new AppointmentEntity(appointmentInterval2, doctor2, patient2, LocalDate.now().plusDays(17)));	
		
	}
}
