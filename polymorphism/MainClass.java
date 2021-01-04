package polymorphism;
public class MainClass {
    public static void main(String[] args) {
        Dog d = new Dog();
    
        Pet p = d; //Upcasting / implicit casting
        Animal a = p;
//Overriding is runTIme polymorphism :- mtds with same signature, but associated in a class and its subclass  
        d.walk(); //will give "dog is walking"
        p.walk(); //will also give "dog is walking"
//This is called "RUN TIME POLYMORPHISM" -- It checks on run time, it finds that p is also dog's object
//compiler can't tell which func is it going to be called in subclass
       // a.walk(); Error, Compile Time checking
        System.out.println(d.name);// give "Dobby"
        System.out.println(p.name);// give "Mike".....therfore variables are nevr overrided, only mtds can
       greetings();  //compiler knows where to go
       greetings("Hi Naman"); //there are multiple behaviour of "greetings" mtd...polymorphism
       
    }
// mtd overloading is COMPILE TIME POLYMORPHISM :- mtds with same name but diff signature & return type     
    public static void greetings(){
        System.out.println("Hi there");
    }
    public static void greetings(String s){
        System.out.println(s);
    }
}
