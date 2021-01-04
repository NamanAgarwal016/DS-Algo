package designPatterns;

// Singleton pattern is used when we want to allow only a single instance of a class can be created inside our application.
// It's a creational pattern as it is responsible for creating objects of classes

public class SingletonPattern {
	private static SingletonPattern xyz = null;		// Once initialized, It will retain it's value as it is static
	
	private SingletonPattern() {
		
	}
	
	public static synchronized SingletonPattern getInstance() {		// synchronized bcoz:  to make it thread safe, it maybe possible that 2 instances are created by 2 threads
		if(null == xyz) {					// Means the obj isn't created even once 
			xyz = new SingletonPattern();
		}
		return xyz;
	}
	
	protected Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException("Clone is not allowed");
	}
	
	public static void main(String[] args) {
		SingletonPattern s = new SingletonPattern();
	}
}
