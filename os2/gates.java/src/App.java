 import java.io.BufferedReader;
// import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.FileReader;
//  import java.io.IOException;
//  import java.util.ArrayList;
//  import java.util.List;
// import java.util.Scanner;
import java.io.IOException;


public class App {
    public static void main(String[] args) throws Exception {
          readfile();
        }


        public static void readfile() throws IOException{
            FileReader myObj = new FileReader("cars.txt");
            try (BufferedReader reader = new BufferedReader(myObj)) {
                   String line;
                   while ((line = reader.readLine()) != null) {
                       String[] parts = line.split(",");
                       if (parts.length == 4 ) {
                           int gateId =Integer.parseInt(parts[0].trim().split(" ")[1]);
                           int carId =Integer.parseInt(parts[1].trim().split(" ")[1]);
                           int arrivalTime = Integer.parseInt(parts[2].trim().split(" ")[1]);
                           int parkeId = Integer.parseInt(parts[3].trim().split(" ")[1]);
       
                         Car cars = new Car(carId, arrivalTime, parkeId);
                         Gates gate = new Gates(cars, gateId);
                         gate.run();
                         
                       }
                   }
            } 
            catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        }
}
