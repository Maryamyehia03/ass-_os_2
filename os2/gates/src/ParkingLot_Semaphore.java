// package org.example;

public class ParkingLot_Semaphore {

    private int availableSpots;
    

    public ParkingLot_Semaphore(int spots) {
        this.availableSpots = spots;
    }

    public synchronized boolean Try_toEnter() {
        if (availableSpots > 0) {
            availableSpots--; // Occupy a spot
            return true;
        }
        return false;
    }

    public synchronized void Enter_spot() {
        while (availableSpots == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        availableSpots--;
    }

    public synchronized void exit_spot() {
        availableSpots++;
        notify();
    }

    public synchronized int available_Spots() {
        return availableSpots; // Return the number of available spots
    }
}

