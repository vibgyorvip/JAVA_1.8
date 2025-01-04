package CodingQuestion;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx2 {

    public static void main(String[] args) {

        //Given a sentence , find and print the frequency of each word.
        String sentence = "Java is a programming language. Java is versatile.";

        Map<String, Long> tokenizeStrings = Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        System.out.println(tokenizeStrings);


        //Given a List of Integers, find out all the numbers starting with 1.
        List<Integer> nums = Arrays.asList(12, 13, 18, 21, 90, 11);
        List<Integer> numsWithOne = nums.stream().filter(n -> String.valueOf(n).startsWith("1")).collect(Collectors.toList());
        System.out.println(numsWithOne);

        //Given a List of names, group them by their first letter, and then count the numbers of names in each group.
        String[] str = {"Alice", "Bob", "Charlie", "Amy", "Bill", "Anna"};
        //using collect(Collectors.groupingBy(classifier, downstream reduction)
        Map<Character, Long> map = Arrays.stream(str).collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
        System.out.println(map);

        //Find and print duplicate numbers in an array if it contains multiple duplicates ?
        int[] arr = {2, 4, 6, 1, 2, 4, 6, 32, 5, 6};

        Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);


        //remove duplicates from array
        int[] arr1 = {1, 2, 3, 4, 1, 2, 3, 1, 2};

        int[] newArray = Arrays.stream(arr1).distinct().toArray();
        System.out.println(Arrays.toString(newArray));

        //Given a List of words. filter and print Palindromes.
        List<String> words = List.of("level", "hello", "radar", "world", "deed");

        List<String> palindromes = words.stream().filter(s -> s.equals(new StringBuilder(s).reverse().toString())).collect(Collectors.toList());
        System.out.println(palindromes);


        //How to you merge 2 sorted Array into single sorted Array.

        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};

        int[] sortedArray = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).sorted().toArray();
        System.out.println(Arrays.toString(sortedArray));


        //Given two List of String, concatenate them and remove duplicates.

        List<String> list1 = List.of("apple", "banana", "orange");
        List<String> list2 = List.of("banana", "kiwi", "grape");

        List<String> uniqueList = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
        System.out.println(uniqueList);


        //Student Grade classification -70 and above pass.

        List<Student> students = List.of(
                new Student("Alice", 85),
                new Student("Bob", 70),
                new Student("Charlie", 65),
                new Student("David",90)
                );

        List<Student> studentList = students.stream().filter(student -> student.getGrade() >= 70).collect(Collectors.toList());
        System.out.println(studentList);

        Map<String, List<Student>> studentMap = students.stream()
                .collect(Collectors.groupingBy(student -> student.getGrade() >= 70 ? "PASS" : "FAIL"));
        System.out.println(studentMap);

        //Given a List of strings, sort them according to increasing order of their length.

        List<String> fruits = Arrays.asList("Mango", "Apple", "Banana", "Kiwi");
        List<String> collect = fruits.stream().sorted((s1, s2) -> s1.length() - s2.length()).collect(Collectors.toList());
        System.out.println(collect);

        fruits.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);

        //Partition a list of numbers into two groups: even and odd, using a custom predicate.
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitionedNumbers);

        //Find the squares of the first three even numbers in a list.
        List<Integer> squareList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(squareList);

        //Flatten a list of lists
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4), Arrays.asList(5,6), Arrays.asList(7,8));

        List<Integer> collect1 = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(collect1);

    }
}

class Student{
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
