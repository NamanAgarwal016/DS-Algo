package packages;
import packages.oneMorePackage.Teacher;

public class MainClass {
    public static void main(String[] args) {
        Student student = new Student("Naman");
        System.out.println(Student.getName());
        
        Teacher teacher = new Teacher("Goyal Sir");
        System.out.println(Teacher.name);
        
        // video at 14:53
    }
}
