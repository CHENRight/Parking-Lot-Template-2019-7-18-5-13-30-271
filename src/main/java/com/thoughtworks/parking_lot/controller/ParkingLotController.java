package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.Car;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.service.ParkingLotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {

    @Autowired
    private ParkingLotServiceImpl parkingLotService;

    @PostMapping
    public ParkingLot save(@RequestBody ParkingLot parkingLot){
        return parkingLotService.save(parkingLot);
    }



    @DeleteMapping("/{name}")
    public List<ParkingLot> deleteParkingLotByName(@PathVariable String name){
        return parkingLotService.delete(name);
    }

    @GetMapping(params = {"page"})
    public Page<ParkingLot> findAllAndPage(@RequestParam int page, @RequestParam(defaultValue = "15",required = false) int pageSize){
        return parkingLotService.findAndPage(page,pageSize);
    }

    @GetMapping("/{name}")
    public ParkingLot findByName(@PathVariable String name){
        return parkingLotService.findByName(name);
    }

    @PutMapping
    public ParkingLot updateCapacity(@RequestBody ParkingLot parkingLot){
        return parkingLotService.update(parkingLot);
    }

    @PostMapping("/{id}/parkingOrders")
    public ResponseEntity<ParkingOrder> park(@PathVariable String id, @RequestBody Car car){
        return ResponseEntity.ok(parkingLotService.park(id,car));
    }

    @PutMapping("/{id}/parkingOrders")
    public ParkingOrder fetch(@PathVariable String id,@RequestBody Car car){
        return parkingLotService.fetch(id,car);
    }

}
