package CodingQuestion;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx1 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        //Find the sum of all elements in the List using streams.
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum : " + sum);

        //Given a List of integers, find max element using stream.
        int max = list.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Max : " + max);


        //Given a List of strings, count the number of strings that start with a specific character using stream.
        List<String> stringList = Arrays.asList("Vipul","Vivek","Anil");
        long count = stringList.stream().filter(s -> s.toLowerCase().charAt(0) == 'v').count();
        long count1 = stringList.stream().filter(s -> s.startsWith("V")).count();

        System.out.println("Count : "+count);
        System.out.println(count1);

        //Covert a List of Strings to uppercase using streams.
        List<String> collect = stringList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect);

        stringList.stream().map(String::toUpperCase).forEach(System.out::println);


        //Given a List of integers, to filter out even number
        //count the number of elements in a list satisfy above condition.
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        long countOfEven = numbers.stream().filter(num -> num%2==0).count();
        System.out.println("Count of even number : "+countOfEven);

        //Find average of a List of floating-point numbers using streams.
        List<Double> floatNumbers = Arrays.asList(1.1,1.2,1.3,1.4,1.5);
        Double average = floatNumbers.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println("Average is : "+average);

        //Given a List of String , to concatenate all the strings using stream.
        List<String> stmt = Arrays.asList("I","AM","A","JAVADEVELOPER");
        String output = stmt.stream().collect(Collectors.joining(","));
        System.out.println(output);

        // To remove duplicates element from List using Stream.
        List<Integer> duplicateList = Arrays.asList(1,2,3,4,5,1,2,3);
        duplicateList.stream().distinct().forEach(System.out::println);
        
        //Given a List of Object , to sort the objects based on a specific attribute using Streams.
        List<Person> people = Arrays.asList(
            new Person("Alice",28),
            new Person("Anna",29),
            new Person("Bob",30),
            new Person("Barbie",56),
            new Person("Charlie",20));

        people.stream().sorted((a,b)->a.getName().compareTo(b.getName())).forEach(System.out::println);
        Collections.sort(people,Comparator.comparing(Person::getAge));
        System.out.println(people);
        people.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
    

        //To check all elements in a List satisfy a given condition using streams.
        List<Integer> numList = Arrays.asList(2,4,6,8,10);
        boolean isEven = numList.stream().allMatch(num -> num%2 == 0);
        System.out.println(isEven);
    }
}

class Person implements Comparable{
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    String getName(){
        return this.name;
    }

    void setName(String name){
        this.name = name;
    }

    int getAge(){
        return this.age;
    }

    void setName(int age){
        this.age = age;
    }

    public String toString(){
        return this.name+"--"+this.age;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return this.age<p.getAge()?-1:this.age>p.getAge()?1:0;
    }
}
