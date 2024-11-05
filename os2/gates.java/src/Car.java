public class Car extends Thread {
    private final int carId;
    private final int arrivalTime; 
    private final int parkeId;

    public Car(int carId, int arrivalTime,int parkeId ) {
        this.carId = carId;
        this.parkeId = parkeId; 
        this.arrivalTime = arrivalTime;
    }
    public void arrive(){
        System.out.println(carId + " " + arrivalTime + " " + parkeId );

    }
  
    public int getCarId() {
        return carId;
    }
}
