package com.thoughtworks.parking_lot.entity;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Car {

    @Id
    private String id;

    private String carNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parkingOrderId")
    private ParkingOrder parkingOrder;

    public Car(){}
    public Car(String carNumber, ParkingOrder parkingOrder) {
        this.carNumber = carNumber;
        this.parkingOrder = parkingOrder;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ParkingOrder getParkingOrder() {
        return parkingOrder;
    }

    public void setParkingOrder(ParkingOrder parkingOrder) {
        this.parkingOrder = parkingOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(carNumber, car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carNumber);
    }
}
