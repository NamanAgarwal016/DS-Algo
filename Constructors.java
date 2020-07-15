//Constructors are use to initialize objects at the time of making.  iniitialize state variables instantly
//looks similar to methods
//it doesnt have return type
//constructor name = class name
//By default, a constructor is called when object is instantialized
//this keyword: it refers to the current object that is made, it keeps the refrence of the present obj formed, points 
//towards current object formed.
//Constructor Overloading: 
//If constructor is defined by us then, can we still call its default constructor?? NOoooo..we cant

class Vehicle{
    int wheels;
    int headlights;
    String color;
    Vehicle(){
        wheels = 4;
        headlights = 2;
    }
    Vehicle(int wheels){       //Overloading ..different signature
        this.wheels = wheels;
        headlights = 2;
    }
    Vehicle(int wheels, String color){
        this.wheels = wheels;
        this.color = color;
    }
}

public class Constructors {
    Constructors(){
        System.out.println("Object is now created");//whatever written in this will be executed as soon as object is made
    }
    public static void main(String[] args) {
        Constructors obj = new Constructors();
        
        Vehicle car = new Vehicle();
        Vehicle train = new Vehicle(100);
        Vehicle scooty = new Vehicle(2);
        Vehicle bike = new Vehicle(2, "black");
        System.out.println(car.wheels + " wheels and headlights " + car.headlights);
        System.out.println(train.wheels + " wheels and headlights " + train.headlights);
        System.out.println(scooty.wheels + " wheels and headlights " + scooty.headlights);
        System.out.println(bike.wheels + " wheels and color " + bike.color);
        
    }
}


