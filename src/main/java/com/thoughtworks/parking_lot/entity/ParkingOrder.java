package com.thoughtworks.parking_lot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class ParkingOrder {

    @Id
    private String id;
    private String parkingName;
    private String carNumber;
    private Date createDate;
    private Date fetchDate;
    private boolean orderStatus = true;

    public ParkingOrder(String parkingName){
        this.parkingName = parkingName;
    }
    public ParkingOrder(String parkingName, String carNumber) {
        this.parkingName = parkingName;
        this.carNumber = carNumber;
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

    public void setOrderStatus(boolean orderStstus) {
        this.orderStatus = orderStstus;
    }

    public String getId() {
        return id;
    }

    public String getParkingName() {
        return parkingName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getFetchDate() {
        return fetchDate;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }
}
