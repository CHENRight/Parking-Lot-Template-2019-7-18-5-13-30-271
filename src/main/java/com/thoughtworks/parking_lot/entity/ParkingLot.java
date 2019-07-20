package com.thoughtworks.parking_lot.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ParkingLot {

    @Id
    private String id;

    @Column(unique = true)
    private String name;
    private int capacity;
    private String address;

    public ParkingLot() {}

    public ParkingLot(String name, int capacity, String address) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parkingLotId")
    private List<Car> cars;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parkingLotId")
    private List<ParkingOrder> parkingOrders;


    public boolean isFull(){
        return capacity <= cars.size();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<ParkingOrder> getParkingOrders() {
        return parkingOrders;
    }

    public void setParkingOrders(List<ParkingOrder> parkingOrders) {
        this.parkingOrders = parkingOrders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
