//-------------ENCAPSULATION---------
//To do do encapsulation:In the other class from which info has to 
//be accessed first, make variables private.
//Then make public getters and setters method.
//By using getters&setters mtd we are able to put cond on when 
//anyone can access that variable in an other class.

package encapsulations;
public class EncapsulationIntroduction {
    public static void main(String[] args) {
        Student obj = new Student();
     //   obj.age = 20;
     //   obj.name = "Naman";
       
        obj.setAge(20);
        System.out.println("Your age is " + obj.getAge());
    }
}
