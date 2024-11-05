package org.example;
import java.util.concurrent.Semaphore;

public class ParkingLot {
    private final Semaphore Park_Spots;
    private int total_cars = 0; //this will be the counter of all served cars

    public ParkingLot() {
        this.Park_Spots = new Semaphore(4); // This will limit spots of parking to be only 4 spots
    }

    public void Car_Enter(Car car, int waitingTime) {
        try {
            if (Park_Spots.tryAcquire()) { //here car will Try to acquire a parking spot
                total_cars++;
                log_activity("Car " + car.getCarId() + " from Gate " + car.getGateId() + " parked. (Parking Status: " + (4 - Park_Spots.availablePermits()) + " spots occupied)");
                Thread.sleep(waitingTime * 1000); //this will Simulate parking time
                Car_Leave(car);
            }

            else { // If there is no available spot, wait for one to be set free
                log_activity("Car " + car.getCarId() + " from Gate " + car.getGateId() + " waiting for a spot.");
                Park_Spots.acquire();

                
                /*still not sure of time here */
                log_activity("Car " + car.getCarId() + " from Gate " + car.getGateId() + " parked after waiting for " + (waitingTime) + " units of time. (Parking Status: " + (4 - Park_Spots.availablePermits()) + " spots occupied)");
                Thread.sleep(waitingTime * 1000); // this will Simulate parking time
                Car_Leave(car);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void Car_Leave(Car car) {
        Park_Spots.release();//this will set the spot of leaving car to be free again
        log_activity("Car " + car.getCarId() + " from Gate " + car.getGateId() + " left after " + car.getParkeDuration() +"of time. (Parking Status: " + (4 - Park_Spots.availablePermits()) + " spots occupied)");
    }

    public void log_activity(String message) {
        System.out.print(message + "\n");
    }
}

