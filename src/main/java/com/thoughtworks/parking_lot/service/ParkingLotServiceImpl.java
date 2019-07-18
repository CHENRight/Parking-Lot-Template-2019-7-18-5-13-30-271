package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.Car;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingLotServiceImpl implements ParkingLotService{
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public ParkingLot save(ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
    }

    public List<ParkingLot> findAll(){
        return parkingLotRepository.findAll();
    }

    public List<ParkingLot> delete(String name){
        parkingLotRepository.deleteById(name);
        return parkingLotRepository.findAll();
    }

    public Page<ParkingLot> findAndPage(int page, int pageSize){
        return parkingLotRepository.findAll(PageRequest.of(page,pageSize));
    }

    public ParkingLot findByName(String name){
        return parkingLotRepository.findById(name).get();
    }

    public ParkingLot update(ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
    }

    public ParkingOrder park(String parkingLotId, Car car){
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).get();
        if (parkingLot.isFull()) {
            throw new RuntimeException("Not Enough Positions");
        }
        ParkingOrder order = new ParkingOrder(parkingLot.getName(), car.getCarNumber());
        order.setCreateDate(new Date());
        parkingLot.getParkingOrders().add(order);
        return parkingLotRepository.save(parkingLot).getParkingOrders().stream().filter(item -> item.getCarNumber().equals(car.getCarNumber())).collect(Collectors.toList()).get(0);
    }

    public ParkingOrder fetch(String parkingLotId,Car car){
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).get();
        ParkingOrder order = parkingLot.getParkingOrders().stream().filter(item -> item.getCarNumber().equals(car.getCarNumber())).collect(Collectors.toList()).get(0);
        parkingLot.getParkingOrders().remove(order);
        order.setOrderStatus(false);
        order.setFetchDate(new Date());
        car.setParkingOrder(null);
        parkingLot.getParkingOrders().add(order);
        parkingLotRepository.save(parkingLot);
        return order;
    }

}
