package abstraction;
public class Audi extends Car {
    public void braking(){
        System.out.println("Audi is braking");
    }
    @Override  //Annotation
    public void accelerate() {
        System.out.println("Audi is accelerating");
    }
}
