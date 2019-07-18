package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.ParkingLotServiceImpl;
import org.h2.command.dml.Delete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class ParkingLotControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    private ParkingLotServiceImpl parkingLotService;

    private ParkingLot initParkingLot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId("1111");
        parkingLot.setCapacity(10);
        parkingLot.setName("FirstParkingLot");
        parkingLot.setAddress("ZHA");
        return parkingLot;
    }


    @Test
    void should_return_parking_lot_after_saved_parking_lot() throws Exception {
        ParkingLot parkingLot = initParkingLot();
        when(parkingLotService.save(any())).thenReturn(parkingLot);

        ResultActions result = mockMvc.perform(post("/parkinglots").content("{}").contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.id", is("1111")));
    }

    @Test
    void should_delete_the_parking_lot() throws Exception {
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        parkingLot1.setName("first");
        parkingLot1.setAddress("ZHA");
        parkingLot1.setCapacity(1);
        ParkingLot parkingLot2 = new ParkingLot("second",1,"xinagzhou");
        parkingLots.addAll(Arrays.asList(parkingLot1,parkingLot2));
        List<ParkingLot> result = new ArrayList<>(); result.add(parkingLot2);

        when(parkingLotService.delete("first")).thenReturn(result);

        ResultActions resultActions = mockMvc.perform(delete("/parkinglots/{name}",parkingLot1.getName()));

        resultActions.andExpect(status().isOk()).andExpect(jsonPath("$.[0].id",is("first")));

    }


}