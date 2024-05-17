// package ro.unibuc.hello.controller;

// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.util.Arrays;
// import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import ro.unibuc.hello.dto.AppointmentInterval;
// import ro.unibuc.hello.service.AppointmentIntervalService;

// @ExtendWith(MockitoExtension.class)
// @WebMvcTest(AppointmentIntervalController.class)
// @AutoConfigureMockMvc
// public class AppointmentIntervalControllerTest {

//     @Mock
//     private AppointmentIntervalService appointmentIntervalService;

//     @InjectMocks
//     private AppointmentIntervalController appointmentIntervalController;

//     private MockMvc mockMvc;

//     @BeforeEach
//     public void setUp() {
//         mockMvc = MockMvcBuilders.standaloneSetup(appointmentIntervalController).build();
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     public void test_getAppointmentIntervals() throws Exception {
//         // Create appointment intervals
//         AppointmentInterval appointmentInterval1 = new AppointmentInterval("1", 12, 30);
//         AppointmentInterval appointmentInterval2 = new AppointmentInterval("2", 13, 12);

//         // Create a list of appointment intervals
//         List<AppointmentInterval> appointmentIntervals = Arrays.asList(appointmentInterval1, appointmentInterval2);

//         // Mock the service method
//         when(appointmentIntervalService.getAllAppointmentIntervals()).thenReturn(appointmentIntervals);

//         // Perform the request and verify the response
//         mockMvc.perform(get("/appointmentInterval"))
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$[0].id").value("1"))
//             .andExpect(jsonPath("$[0].hour").value(12))
//             .andExpect(jsonPath("$[0].minute").value(30))
//             .andExpect(jsonPath("$[1].id").value("2"))
//             .andExpect(jsonPath("$[1].hour").value(13))
//             .andExpect(jsonPath("$[1].minute").value(12));
//     }
// }
