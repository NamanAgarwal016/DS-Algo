package singletons;
public class MainClass {
    AppConfig obj1 = AppConfig.getInstance(); //making obj by using mtd in static class AppConfig
                                            // mtds of static class can be accessed by using class name and dot.
    
    AppConfig obj2 = AppConfig.getInstance(); // Now these all obj are same...equal to that single object formed in
    AppConfig obj3 = AppConfig.getInstance(); // that AppConfig class i.e. objMain 
    AppConfig obj4 = AppConfig.getInstance();// we accessing only objMain always in whole app..therefore not using memory
}                                             // again and again.
