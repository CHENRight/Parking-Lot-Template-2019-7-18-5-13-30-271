package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {

    @Autowired
    private ParkingLotServiceImpl parkingLotService;

    @DeleteMapping("/{name}")
    public List<ParkingLot> deleteParkingLotByName(@PathVariable String name){
        return parkingLotService.delete(name);
    }

    @GetMapping
    public List<ParkingLot> findAllAndPage(){
        return parkingLotService.findAndPage();
    }

    @GetMapping("/{name}")
    public ParkingLot findByName(@PathVariable String name){
        return parkingLotService.findByName(name);
    }

}
