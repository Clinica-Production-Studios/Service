// package ro.unibuc.hello.controller;

// import static org.mockito.Mockito.doReturn;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.Test;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.junit.MockitoJUnitRunner;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.test.web.servlet.MvcResult;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.jupiter.api.Assertions;

// import ro.unibuc.hello.dto.AppointmentInterval;
// import ro.unibuc.hello.service.AppointmentIntervalService;




// //@ExtendWith(SpringExtension.class)
// @ExtendWith(MockitoExtension.class)
// @RunWith(MockitoJUnitRunner.class)
// public class AppointmentIntervalControllerTest {

//     @Mock
//     private AppointmentIntervalService appointmentIntervalService;

//     @InjectMocks
//     private AppointmentIntervalController appointmentIntervalController;

//     private MockMvc mockMvc;

//     private ObjectMapper objectMapper;

//     @BeforeEach
//     public void setUp()
//     {
//         //MockitoAnnotations.openMocks(this);
//          mockMvc = MockMvcBuilders.standaloneSetup(appointmentIntervalController).build();
//         objectMapper = new ObjectMapper();
//     }

//     @Test
//     public void test_getAppointmentIntervals() throws Exception {

//         AppointmentInterval appointmentInterval = new AppointmentInterval("1", 12, 30);
//         List<AppointmentInterval> appointmentIntervals = new ArrayList<>();
//         appointmentIntervals.add(appointmentInterval);

//         when(appointmentIntervalService.getAllAppointmentIntervals()).thenReturn(appointmentIntervals);
//         // doReturn(appointmentIntervals).when(appointmentIntervalService.getAllAppointmentIntervals());

//         MvcResult result = mockMvc.perform(get("/appointmentInterval")
//         .contentType(MediaType.APPLICATION_JSON))
//         .andExpect(status().isOk())
//         .andReturn();

//         Assertions.assertEquals(result.getResponse().getContentAsString().contains(appointmentInterval.getId()), true);
//     }


// }
