package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService{
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public List<ParkingLot> delete(String name){
        parkingLotRepository.deleteById(name);
        return parkingLotRepository.findAll();
    }


}
