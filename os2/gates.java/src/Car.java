public class Car extends Thread {
    private final int carId;
    private final int arrivalTime; 
    private final int parkeDuration;
    private final int gateId;

    public Car(int carId, int arrivalTime,int parkeDuration , int gateId ) {
        this.carId = carId;
        this.parkeDuration = parkeDuration; 
        this.arrivalTime = arrivalTime;
        this.gateId=gateId;
    }
    public void arrive(){
        System.out.println(carId + " " + arrivalTime + " " + parkeDuration );

    }
  
    public int getCarId() {
        return carId;
    }
    public int getGateId() {
        return gateId;
    }
    public int getParkeDuration() {
        return parkeDuration;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
}
