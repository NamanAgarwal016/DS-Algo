                        //start
// lines below return are not executed
// in static method only static ethods can be called..non-static mtd can't be referenced from static context
// 2 mtds with same signature and name cannot be there. 
// mtd overloading = same name but diff signature mtds allowed in 1 class.
// return type does not come under signature of mtd... signature = arguments
// Java is pass by value always
//For non-primitive data type(EX class), there also it is pass by value, but the object reference is passed
// there is no duplicate copy of object made, refrence of that object is passed instead
class Lion{
    int legs;
}

public class Methods {
    public static void main(String[] args) {
        sayHi();
        int firstNum = 31;
        int secondNum = 52;
        System.out.println(maxOf(firstNum, secondNum));
        sayHi();
        
        Lion lionA = new Lion();
        lionA.legs = 4;
        Lion lionB = new Lion();
        lionB.legs = 3;
        swap(lionA, lionB);
        System.out.println("Now lionA has " + lionA.legs); // ans will be still 4
        
        changeLion(lionA);
        System.out.println("Now lionA has " + lionA.legs); // ans will be 6
        
                
    }
    static int maxOf(int a, int b){
        return a > b ? a : b; 
    }
    static void sayHi(){
        System.out.println("Hi !!!!!!!!");
    }
    
    
    static void swap(Lion a, Lion b){
        Lion temp = a;
        a=b;
        b=temp;
    }
    static void changeLion(Lion lion){
        lion.legs = 6;
    }
}

