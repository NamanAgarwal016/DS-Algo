package comparablesAndComparators;

import java.util.*;

public class MainClass {
	public static void main(String[] args) {

		// Comparables

		List<Student> students = new ArrayList<Student>();

		students.add(new Student(53, "Ram"));
		students.add(new Student(53, "Naman"));
		students.add(new Student(93, "Anuj"));
		students.add(new Student(72, "Aman"));
		students.add(new Student(53, "Anubhav"));

//		for (Student student : students) {
//			System.out.println(student); // same as student.toString()
//		}

		// Lambda expressions for making code more compact

		students.forEach(System.out::println); // for line 16, 17, 18

		Collections.sort(students);
		System.out.println();
		students.forEach(System.out::println);

		// Comparators

		List<StudentWithoutComparable> students1 = new ArrayList<>();

		students1.add(new StudentWithoutComparable(53, "Ram"));
		students1.add(new StudentWithoutComparable(53, "Naman"));
		students1.add(new StudentWithoutComparable(93, "Naman"));
		students1.add(new StudentWithoutComparable(72, "Anuj"));
		students1.add(new StudentWithoutComparable(53, "Anubhav"));

		Collections.sort(students1, new SortByNameThenMarks());
		System.out.println();
		students1.forEach(System.out::println);

		// Comparators without making a new class, by anonymous comparator class

		Collections.sort(students1, new Comparator<StudentWithoutComparable>() {

			@Override
			public int compare(StudentWithoutComparable o1, StudentWithoutComparable o2) {
				return o1.marks - o2.marks;
			}
		});
		System.out.println();
		students1.forEach(System.out::println);

		// Using Lambda expression

		Collections.sort(students1, (o1, o2) -> o2.marks - o1.marks);

		System.out.println();
		students1.forEach(System.out::println);

		// Using comparing method of comparator class + Lambda expression
		// Comparator.comparing() => thenComparing() => reverseOrder()

		Collections.sort(students1, Comparator.comparing(StudentWithoutComparable::getName)
				.thenComparing(StudentWithoutComparable::getMarks).reversed());
		System.out.println();
		students1.forEach(System.out::println);
	}
}

class SortByNameThenMarks implements Comparator<StudentWithoutComparable> {

	@Override
	public int compare(StudentWithoutComparable o1, StudentWithoutComparable o2) {
		if (o1.name.equals(o2.name)) {
			return o1.marks - o2.marks;
		} else {
			return o1.name.compareTo(o2.name);
		}
	}

}
