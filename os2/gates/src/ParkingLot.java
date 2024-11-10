// package org.example;

import java.time.Duration;
import java.time.Instant;

public class ParkingLot {
    private final ParkingLot_Semaphore park_Spots;

    public int current_available_spots = 0;

    public ParkingLot() {
        this.park_Spots = new ParkingLot_Semaphore(4);
    }

    public void Car_Enters_Parking(Car car, int parkDuration) {
        try {
            Instant waitingStart = Instant.now();
            if (park_Spots.Try_toEnter()) {
                current_available_spots++;
                // car.setWaitingTime(0); // No waiting if we get a spot immediately
                System.out.println("Car " + car.getCarId() + " from Gate " + car.getArrivalGateId() +
                        " parked. (Parking Status: " + (current_available_spots) + " spots occupied)");
                Thread.sleep(parkDuration * 1000);
                Car_Leaves_Parking(car);
            } else {
                // If no spots are available, wait for a spot to be freed
                System.out.println("Car " + car.getCarId() + " from Gate " + car.getArrivalGateId() + " waiting for a spot.");
                park_Spots.Enter_spot(); // Enter the spot once it is available

                Instant waitingEnd = Instant.now();
                long totalWaiting = Duration.between(waitingStart, waitingEnd).getSeconds();
                current_available_spots++;
                System.out.println("Car " + car.getCarId() + " from Gate " + car.getArrivalGateId() +
                        " parked after waiting for " + totalWaiting + " units of time. (Parking Status: " +
                        (current_available_spots) + " spots occupied)");
                Thread.sleep(parkDuration * 1000); // Simulate parking duration
                Car_Leaves_Parking(car); // After parking duration, leave
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Car " + car.getCarId() + " from Gate " + car.getArrivalGateId() + " was interrupted.");
        }
    }

    // Method for cars to leave the parking lot
    public void Car_Leaves_Parking(Car car) {
        park_Spots.exit_spot(); // Release the parking spot
        current_available_spots--;
        System.out.println("Car " + car.getCarId() + " from Gate " + car.getArrivalGateId() +
                " left after " + car.getParkeDuration() + " units of time. (Parking Status: " +
                (current_available_spots) + " spots occupied)");

    }

}











