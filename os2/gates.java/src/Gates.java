// import java.util.concurrent.Semaphore;

public class Gates extends Thread{

        private int gateId ;
        private Car mycar;
        // Semaphore availablegates;

    public Gates (Car cars , int gateId){
        this.gateId = gateId;
        this.mycar = cars;
    }

    @Override
    public synchronized void run(){
        if (gateId==1) {
            System.out.println("gate 1");
           
            try {
                 mycar.arrive();
                mycar.join();
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }
        else if (gateId ==2) {
            System.out.println("gate 2");
            try {
                mycar.arrive();
               mycar.join();
           } catch (InterruptedException e) {
               
               e.printStackTrace();
           }
        } 
        else if (gateId == 3) {
            System.out.println("gate 3");
            try {
                mycar.arrive();
               mycar.join();
           } catch (InterruptedException e) {
               
               e.printStackTrace();
           }
        }
    }
    
}
