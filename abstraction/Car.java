package abstraction;
public abstract class Car {
    public abstract void accelerate();
    public abstract void braking();
    
    public void honking(){  //Concrete mtd
        System.out.println("Audi is honkin");
    }

}
