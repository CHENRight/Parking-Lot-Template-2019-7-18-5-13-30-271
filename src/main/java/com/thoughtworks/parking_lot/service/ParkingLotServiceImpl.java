package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService{
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public List<ParkingLot> delete(String name){
        parkingLotRepository.deleteById(name);
        return parkingLotRepository.findAll();
    }

    public List<ParkingLot> findAndPage(){
        List<ParkingLot> parkingLots = parkingLotRepository.findAll();
        return parkingLots.subList(0,15);
    }

    public ParkingLot findByName(String name){
        return parkingLotRepository.findById(name).get();
    }

    public ParkingLot update(ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
    }


}
