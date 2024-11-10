// package org.example;
import java.util.concurrent.Semaphore;

public class Gate {

    private final int gateId;
    private int gateCounter=0;

    
    private final Semaphore gateSemaphore; // Binary semaphore for controlling access

    public Gate(int gateId) {
        this.gateId = gateId;
        this.gateSemaphore = new Semaphore(1); // Binary semaphore initialized with 1 permit
    }

    public int getGateCounter(){
        return gateCounter;
    }
    // Method to process a car passing through this gate
    public void processCar(Car car) {
        try {
            gateCounter++;
            gateSemaphore.acquire(); // Acquire the semaphore to grant access to the car
            car.arrive(); // Simulate car arriving
            car.start();  // Start car's activity (assuming Car extends Thread or has a similar mechanism)
           
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.out.println("Car " + car.getCarId() + " from Gate " + gateId + " was interrupted.");
        } finally {
            gateSemaphore.release(); // Release the semaphore once processing is complete
           
        }
    }
}

