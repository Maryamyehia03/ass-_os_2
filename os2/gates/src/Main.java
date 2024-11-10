// package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws InterruptedException {

        
        int carCounter = 0;
        ParkingLot parkinglot = new ParkingLot();
        List<Thread> threads = new ArrayList<>();

        // Create Gate instances
        Gate gate1 = new Gate(1);
        Gate gate2 = new Gate(2);
        Gate gate3 = new Gate(3);

        // Process cars at each gate based on their arrival
        try {
          File logFile = new File("cars.txt");
          Scanner fileReader = new Scanner(logFile);
          while (fileReader.hasNextLine()) {
              String line = fileReader.nextLine();
              line = line.replaceAll("[^\\d]", " ");
              line = line.trim();
              line = line.replaceAll(" +", " ");
              String[] numbers = line.split(" ");
              int gateNum = Integer.parseInt(numbers[0]);
              int carId = Integer.parseInt(numbers[1]);
              int arrival = Integer.parseInt(numbers[2]);
              int duration = Integer.parseInt(numbers[3]);
              Car car = new Car(parkinglot, carId, gateNum, duration, arrival);
              carCounter++;
              switch (gateNum) {
                  case 1:
                  gate1.processCar(car);
                      break;
                  case 2:
                  gate2.processCar(car);
                      break;
                  case 3:
                  gate3.processCar(car);
                      break;
                  default:
                      continue;
                  }
                  threads.add(car);
  

          }
          fileReader.close();
        
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
     
    

       for (Thread thread : threads) {
           try {
               thread.join();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

        System.out.println("Total cars served: " + carCounter);
        System.out.println("Current Cars in Parking: 0");
        System.out.println("Details:");
        System.out.println("- Gate 1 served "+gate1.getGateCounter()+" cars.");
        System.out.println("- Gate 2 served "+gate2.getGateCounter()+" cars.");
        System.out.println("- Gate 3 served "+gate3.getGateCounter()+" cars.");

    }

    
    
}
