// There can be only 1 public class in 1 java file
// new keyword allocates memory and gives its address to the object.
//unique memory is allocated for every objects defined.
// class doesnt occupies any space in memory it is only blueprint
class Cat {
    // states
    boolean hasFur;
    String color,breed;
    int legs,eyes;

    //methods
    public void walk() {
        System.out.println("cat is walking");
    }
    public void eat() {
        System.out.println("cat is eating");
    }
    public void description(){
        System.out.println("My cat has " + legs + " legs and " + eyes + " eyes.");
    }
}

class Dog{
    String breed, name;
    
    public void jump(){
        System.out.println("My dog " + name + " jumped.");
    }
}

public class ClassesAndObjects {
    public static void main(String[] args) {
        Cat cat1 = new Cat();                 // making an object of class
        cat1.walk();                          // using any mtd of class
        Cat cat2 = new Cat();
        cat2.eat();
        
        cat1.legs = 4;
        cat1.eyes = 2;
        cat1.description();
        
        Dog dog = new Dog();
        dog.name = "husky";
        dog.jump();
    }
}
