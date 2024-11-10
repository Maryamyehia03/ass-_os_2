// package org.example;

// import java.sql.Date;
// import java.util.*;

public class Car extends Thread {
    private ParkingLot park;
    private int carId;
    private int arrivalGateId;
    private int arrivalTime;
    public int parkDuration;
  
    public Car(ParkingLot ps, int carId, int gateId, int parkDuration, int time) {
        this.park = ps;
        this.carId = carId;
        this.arrivalGateId = gateId;
        this.arrivalTime=time;
        this.parkDuration = parkDuration;
    }

    public int getCarId() {
        return carId;
    }

    public int getArrivalGateId() {
        return arrivalGateId;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getParkeDuration() {
        return parkDuration;
    }

    public void arrive() {
        System.out.println("Car " + carId + " from Gate " + arrivalGateId + " arrived at time " + arrivalTime);
    }


    @Override
    public void run() {
        park.Car_Enters_Parking(this , parkDuration);

        System.out.println("Car " + carId + " from Gate " + arrivalGateId + " completed its parking session.");
    }

   
}


