package CodingQuestion;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEx4 {

    public static void main(String[] args) {

        //List of Students
        List<Student> students = Arrays.asList(
                new Student("Ram", 70),
                new Student("Shyam", 75),
                new Student("Ghanshyam", 80)
        );

        //List of Employee
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", 1000),
                new Employee(2, "Bob", "IT", 1500),
                new Employee(3, "Chalie", "Networking", 500),
                new Employee(4, "Ram", "Networking", 1200)
        );

        // Accumulate Employee names into a List
        List<String> empNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(empNames);

        // Accumulate names into a TreeSet
        TreeSet<String> empNamesIntoTreeSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(empNamesIntoTreeSet);


        // Convert elements to strings and concatenate them, separated by commas
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5);
        String collect = elements.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println(collect);



        // Compute sum of salaries of employee
        Optional<Long> sum  = employees.stream().map(emp -> emp.getSalary()).reduce((x, y) -> x+y);
        sum.ifPresent(System.out::println);

        Long total = employees.stream().collect(Collectors.summingLong(Employee::getSalary));
        System.out.println(total);


        // Group employees by department
        Map<String, List<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment()));
        System.out.println(collect1);

        // Compute sum of salaries by department
        Map<String, Long> collect2 = employees.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.summingLong(emp->emp.getSalary())));
        System.out.println(collect2);

        // Partition students into passing and failing
        Map<Boolean, List<Student>> collect3 = students.stream().collect(Collectors.partitioningBy(student -> student.getGrade() > 70));
        System.out.println(collect3);

    }
}

class Employee {
    int id;
    String name;
    String department;

    long salary;

    public Employee() {

    }

    public Employee(int id, String name, String department, long salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}



