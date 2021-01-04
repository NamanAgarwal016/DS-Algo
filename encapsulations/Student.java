package encapsulations;
public class Student {
    private int age;
    private String name;
    
    public int getAge(){//same Format always
            return age;
        }
    public void setAge(int age){
        if(age > 18) 
            System.out.println("you are adult");
        else this.age = age;
    }
  //automatic done by eclipse/netbean
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
