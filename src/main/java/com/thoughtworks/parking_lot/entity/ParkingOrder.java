package com.thoughtworks.parking_lot.entity;

import java.util.Date;

public class ParkingOrder {

    private int id;
    private String parkingName;
    private String carNumber;
    private Date createDate;
    private Date fetchDate;
    private boolean orderStstus;

    public ParkingOrder() {
        this.orderStstus = true;
    }


    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setFetchDate(Date fetchDate) {
        this.fetchDate = fetchDate;
    }

    public void setOrderStstus(boolean orderStstus) {
        this.orderStstus = orderStstus;
    }
}
