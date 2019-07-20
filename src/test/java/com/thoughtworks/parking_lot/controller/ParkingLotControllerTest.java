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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;
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
    void should_return_status_ok_after_deleted_parking_lot() throws Exception {
        parkingLotService.save(initParkingLot());

        ResultActions result = mockMvc.perform(delete("/parkinglots/{name}", "FirstParkingLot"));

        result.andExpect(status().isOk());

    }


    @GetMapping(params = {"page"})
    public Page<ParkingLot> findAllAndPage(@RequestParam int page, @RequestParam(defaultValue = "15",required = false) int pageSize){
        return parkingLotService.findAndPage(page,pageSize);
    }

//    @Test
//    void should_return_page_when_find_parking_lot_by_page() throws Exception {
//        Page<ParkingLot> page = new PageImpl<>(Collections.singletonList(initParkingLot()));
//
//        when(parkingLotService.findAndPage(anyInt(), anyInt())).thenReturn(page);
//
//        ResultActions result = mockMvc.perform(get("/parkinglots?page={page}", 1));
//
//        result.andExpect(status().isOk());
//    }



}