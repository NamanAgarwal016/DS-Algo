
//1) static keyword is related with class, not with object.
//2) if a variable/mtd is declared static in a class, then it will have only one copy at class level. Means when we will make objects of that
//class, then that variable's copy will not be generated, which use to happen with non static variable/mtd.
//3) Therefore its value will not change.
//4) can be applied to variables, mtds, nested class, blocks.
//5) static keyword can not be used in a non static datatype/mtds/inner class.. Or parent must be static also
//But static keyword can be used in a non static class provided it is main class(public class)
//6) Since none of the object of a class can access static variable(of its class), therefore to use static class we directly use class name
//followed by dot and static variable name. (Ex: Math.PI) (Math is a class and PI is a variable:  public static final double PI=3.1415926)
//7) What is need to make a nested class static?? 
//	A nested static class can be accessed from outside world such that it is not nested. means:
//	for making obj of non-static nested class, first make obj of parent class then obj of nested class. 
//Ex: publicORmain class: A ; inside A nested static class: B ; inside A nested non-static class: C
//We wanna access B,C from a different class of same package as of A. 
//now to access B:  A objA = new A(); A.B objB = objA.new B(); 
//now to access C:  A.C objC = new A.C();
//
//8) Static blocks runs/ intialize as soon as the execution of a class takes place.  they are the first to be executed in a class.
//This can be used when we want some code to be executed before main method of class runs.
//
//
//ques
//How to do: "Don’t let anyone instantiate this class"
//ans
//make the constructor of class private as : private Math() {} 
//also now all things(variables, mtds) need to be make static in this class, so that we can call them directly by class name.


public class StaticKeyword {
    
}
