import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student
{
    private int age;
    private String name;

    public Student() {

    }
    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class ConstructorReference {
    public static void main(String[] args)
    {
        List<String> names= Arrays.asList("Navin","Vipul","John");

        List<Student> students= new ArrayList<>();

        //Using For-Each Loop
//        for (String name: names) {
//            students.add(new Student(name));
//        }
//        System.out.println(students);

        //Using Lambda Expression
//        students = names.stream()
//                .map(name->new Student(name))
//                .toList();
//
//        System.out.println(students);

        //Using Constructor Reference
        students = names.stream()
                .map(Student::new)
                .toList();
        System.out.println(students);


    }
}
