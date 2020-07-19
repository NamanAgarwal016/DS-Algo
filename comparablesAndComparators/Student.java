package comparablesAndComparators;

public class Student implements Comparable<Student>{
	int marks;
	String name;
	
	// All directly by eclipse implementation
	// right click >> source >> Generate ...
	
	public Student(int marks, String name) {
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [marks=" + marks + ", name=" + name + "]";
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student obj) {
		
		// for increasing order : return +ve no. if current obj > obj passed in argument
		if(this.marks > obj.marks) return 1;
		else if(this.marks < obj.marks) return -1;
		
		return this.name.compareTo(obj.name);			// if marks are equal, the sort acc to alphabetical order
		
		// for decreasing order, just reverse the 1 and -1
	}
	
	
	
}
