public class Car extends Thread {
    private final int carId;
    private final int arrivalTime; 
    private final int parkeId;
    private final int gateId;

    public Car(int carId, int arrivalTime,int parkeId , int gateId ) {
        this.carId = carId;
        this.parkeId = parkeId; 
        this.arrivalTime = arrivalTime;
        this.gateId=gateId;
    }
    public void arrive(){
        System.out.println(carId + " " + arrivalTime + " " + parkeId );

    }
  
    public int getCarId() {
        return carId;
    }
    public int getGateId() {
        return gateId;
    }
    public int getParkeId() {
        return parkeId;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
}
