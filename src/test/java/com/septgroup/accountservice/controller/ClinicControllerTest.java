package com.septgroup.accountservice.controller;

import com.septgroup.accountservice.dto.Clinic;
import com.septgroup.accountservice.dto.container.Clinics;
import com.septgroup.accountservice.service.api.ClinicService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ClinicControllerTest {

    @MockBean
    private ClinicService clinicService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllClinicsTest() throws Exception {
        // given
        List<Clinic> clinicList = List.of(
                new Clinic("Halil Land", "42 Yarra Street, Bankstown, Sydney", "0488899931"),
                new Clinic("Test", "Test", "0477712131")
        );
        Clinics clinics = new Clinics(clinicList);
        // when
        clinicService.getAllClinics();
        Mockito.when(clinicService.getAllClinics()).thenReturn(clinics);
        // then
        Mockito.verify(clinicService).getAllClinics();
        mockMvc.perform(MockMvcRequestBuilders.get("/accountinfo/clinic"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.clinics", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clinics[0].clinicName", Matchers.is("Halil Land")));
    }

    @Test
    public void getClinicTest() throws Exception {
        // given
        String clinicName = "Sandy Medical";
        Clinic clinic = new Clinic(clinicName, "497 Ballarat Rd, Sunshine VIC 3020", "000");
        // when
        clinicService.getClinic(clinicName);
        Mockito.when(clinicService.getClinic(clinicName)).thenReturn(clinic);
        // then
        Mockito.verify(clinicService).getClinic(clinicName);
        mockMvc.perform(MockMvcRequestBuilders.get("/accountinfo/clinic/{clinicName}", clinicName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clinicName", Matchers.is(clinicName)));
    }

    @Test
    public void deleteBankAccountTest() throws Exception {
        // given
        String clinicName = "George St Medical Centre";
        // when
        clinicService.deleteClinic(clinicName);
        // then
        Mockito.verify(clinicService).deleteClinic(clinicName);
        mockMvc.perform(MockMvcRequestBuilders.delete("/accountinfo/clinic/{clinicName}", clinicName))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
