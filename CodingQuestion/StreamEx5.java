package CodingQuestion;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx5 {
    public static void main(String[] args) {


        //1. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        List<Integer> integerList = Arrays.asList(1,11,231,14,3,15,4,13,2,6,7);
        List<String> list = integerList.stream().map(Object::toString).filter(n -> n.startsWith("1")).toList();
        System.out.println(list);

        int[] arr = {1,2,11,12,14,54,32,16};
        Arrays.stream(arr).boxed().map(Object::toString).filter(n -> n.startsWith("1")).forEach(System.out::println);

        //2. How to find duplicate elements in a given integers list in java using Stream functions?

        List<Integer> integerList1 = Arrays.asList(1,2,3,4,1,2,3,5,6,7,8,6,7);
        integerList1.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() >1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);



        Set<Integer> set = new HashSet<>();
        integerList1.stream().filter(n -> !set.add(n)).forEach(System.out::println);


        //3. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
        List<Integer> integerList2 = Arrays.asList(1,2,3,4,1);

        boolean status = integerList2.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                .anyMatch(entry -> entry.getValue() > 1);
        System.out.println(status);


        //4. Given a String, find the first repeated character in it using Stream functions?
        String str = "vipulpv";

        Set<Character> set1 = new HashSet<>();
        Optional<Character> first = str.chars().mapToObj(ch -> (char) ch).filter(ch -> !set1.add(ch)).findFirst();
        first.ifPresent(System.out::println);


        Optional<Character> first1 = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst();

        first1.ifPresent(System.out::println);


        //5. Given a String, find the first non-repeated character in it using Stream functions?
        Optional<Character> first2 = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch,LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        first2.ifPresent(System.out::println);

        //6. iven a list of integers, sort all the values present in it in descending order using Streams functions?
        List<Integer> integerList3 = Arrays.asList(1,2,6,94,2,7,0);

        System.out.println(integerList3.stream().sorted().toList());
        System.out.println(integerList3.stream().sorted(Comparator.naturalOrder()).toList());
        System.out.println(integerList3.stream().sorted((a,b)-> a-b).toList());

        System.out.println(integerList3.stream().sorted(Comparator.reverseOrder()).toList());
        //System.out.println(integerList3.stream().sorted(Comparator.naturalOrder().reversed()).collect(Collectors.toList()));
        System.out.println(integerList3.stream().sorted((a,b) -> b-a).toList());

        //7. How will you get the current date and time using Java 8 Date and Time API?
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //8. Write a Java 8 program to concatenate two Streams?
        List<Integer> list1 = Arrays.asList(5,2,6);
        List<Integer> list2 = Arrays.asList(4,1,3);
        List<Integer> concatenatedList = Stream.concat(list1.stream(), list2.stream()).sorted().toList();
        System.out.println(concatenatedList);

        int[] arr1 = {5,2,6};
        int[] arr2 = {4,1,3};
        int[] concatenatedArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
        System.out.println(Arrays.toString(concatenatedArray));

        //9.Write a Java 8 program to sort an array and then convert the sorted array into Streams?
        int[] arr3 = {1,2,3,4};

        Arrays.sort(arr3);

        Stream stream = Arrays.stream(arr3).boxed();
        stream.forEach(System.out::println);

        //10. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?


        //11.  How to count each element/word from the String ArrayList in Java8?
        List<String> words = Arrays.asList("VIP", "APV", "XYZ", "ABC");

        Long collect = words.stream().collect(Collectors.counting());
        System.out.println(collect);

        //12. count of each char in string

        String s = "VIPUL";

        Long collect1 = s.chars().boxed().collect(Collectors.counting());
        System.out.println(collect1);

        //13. Find max in an Array
        int[] arr4 = {1,2,4,5,6,9,3,2,4};

        Arrays.stream(arr4).boxed().max(Comparator.naturalOrder()).ifPresent(System.out::println);
        Arrays.stream(arr4).boxed().max((a,b) -> a-b).ifPresent(System.out::println);

    }
}
