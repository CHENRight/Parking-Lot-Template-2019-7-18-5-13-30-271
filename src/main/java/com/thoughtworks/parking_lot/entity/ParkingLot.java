package com.thoughtworks.parking_lot.entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {

    @UniqueElements
    @Id
    private String name;
    private int capacity;
    private String address;

    public ParkingLot() {}

    public ParkingLot(String name, int capacity, String address) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
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
