package abstraction;
public class RepairShop {
    public static void repairCar(Car car){
        System.out.println("Car is repaired");
    }
   
    public static void main(String[] args) {
        WagonR wagonR = new WagonR();
        Audi audi = new Audi();
     // Car car = new Car();
     // error bcoz abstract class can't be instantiated
        repairCar(wagonR); //works bcoz wagonR is a Car...extends
        repairCar(audi); //works bcoz audi is a Car...extends
    }
}
