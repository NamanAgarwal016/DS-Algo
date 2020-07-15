//----------------Inheritance---------------
//Object Class is pareennt of all classes in java
//Protected variables are only visible to their child classes
//A child can't have multiple parents
//Hierarchial inheritance is allowed
//Multiple inheritance is not allowed
//Method Overriding: child overrides parent's methods
//Upcating & DownCasting
//DownCasting checking is done on run time.Means it will 
//  not show any error while compiling, but error in run
//Super Keyword from video. 26:36--32:04
//Basically, super is used to call parent from child.
package Inheritance;
public class MainClass {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.name = "Mr. Anup";
        t.eat(); t.walk(); t.teach();
        
        Singer s = new Singer(); 
        s.name = "Arijit";
        s.sing(); s.eat(); s.walk();
    }
}
