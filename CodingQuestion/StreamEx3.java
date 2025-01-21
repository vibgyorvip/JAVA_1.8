package CodingQuestion;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {

    //Java8 --> minimal code , Functional programming
    //Stream

    public static void main(String[] args) {
        //Feature introduced in Java 8
        //Process Collection of data in a functional(lambda expression) and declarative(Predicate,function,consumer,supplier) way
        //Simplify data processing(w/o if-else and looping)
        //Embrace Functional Programming
        //Improve Readability and Maintainability
        //Enable Easy Parallelism

        //What is Stream?
        // a sequence of elements supporting functional and declarative programming

        //How to use Stream?
        // Source, intermediate operations & terminal operation


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().filter(x -> x % 2 == 0).count());


        //Intermediate operations transform a stream into another stream
        //They are lazy, meaning they don't execute until a terminal operation is invoked.

        // 1. filter
        List<String> list = Arrays.asList("Akshit", "Ram", "Shyam", "Ghanshyam");
        Stream<String> filteredStream = list.stream().filter(s -> s.startsWith("A"));
        //no filtering at this point
        long count = list.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);

        //2. map
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());

        //3. sorted
        Stream<String> sorted = list.stream().sorted((a, b) -> a.length() - b.length());

        //4. distinct

        //5. flatmap
        //Flatten nested structures (list within lists) so that they can be processed as a single sequence
        //Transform and flatten elements at the same time.

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );

        List<String> flatList = listOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(flatList);

        //Example of flatmap
        List<String> sentences = Arrays.asList(
                "Hello World",
                "Java Programming",
                "flatMap"
        );

        List<String> stringList1 = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .toList();
        System.out.println(stringList1);





        //Termial Operations
        //5. collect
        list.stream().collect(Collectors.toList());

        //6. forEach
        list.stream().forEach(x -> System.out.println(x));

        //7.reduce : Combines elements to produce a single result
        Optional<String> optionalString = list.stream().reduce((x, y) -> x + y);
        optionalString.ifPresent(x -> System.out.println(x));

        //8. anyMatch, allMatch, noneMatch

        boolean a = list.stream().anyMatch(s -> s.startsWith("A"));
        System.out.println(a);

        boolean b = list.stream().allMatch(s -> s.length() > 0);
        System.out.println(b);

        boolean c = list.stream().noneMatch(s -> s.length() < 0);
        System.out.println(c);

        //9. findFirst, findAny
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());


        //Examples
        // Filtering and Collecting Names
        List<String> names = Arrays.asList("Ram", "Shyam", "Ghanshyam");
        List<String> stringList = names.stream().filter(s -> s.length() > 3).toList();
        System.out.println(stringList);

        //Squaring and Sorting Numbers
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> integerList = nums.stream().map(x -> x * x).sorted().toList();
        System.out.println(integerList);


        //summing values
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        Integer integer = nums.stream().reduce(Integer::sum).get();
        System.out.println(integer);

        //Counting Occurrences of a Character
        String sentence = "Hello World";
        //char[] charArray = sentence.toCharArray();
        //Arrays.stream(charArray);

        long count1 = sentence.chars().filter(ch -> ch == 'l').count();
        System.out.println(count1);



        // Example
        //Stream can not be reused after a terminal operation has been called.

        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
       // List<String> stringList2 = stream.map(String::toUpperCase).toList(); //Exception

        //forEachOrdered
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Using forEach with parallel stream: ");
        numbersList.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream: ");
        numbersList.parallelStream().forEachOrdered(System.out::println);




        //Lazy Evaluation
        //Intermediate operations are lazy, meaning they are not executed until a terminal operation (collect(), forEach())
        List<String> name = Arrays.asList("Alice", "Bob", "Charlie", "David");

        Stream<String> stringStream = name.stream()
                .filter(str -> {
                    System.out.println("Filtering: " + str);
                    return str.length() > 3;
                });

        System.out.println("Before terminal operation");

        List<String> result = stringStream.collect(Collectors.toList());

        System.out.println("After terminal operation");
        System.out.println(result);


        //ParallelStream
        //A type of stream that enables parallel processing of elements.
        //Allowing multiple threads to process parts of stream simultaneously.
        //This can significantly improve performance for large data sets.
        //workload is distributed across multiple threads.

        long startTime = System.currentTimeMillis();
        List<Integer> listInteger = Stream.iterate(1,n->n+1).limit(20000).collect(Collectors.toList());
        List<Integer> factorialList = listInteger.stream().map(ParallelStream::factorial).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential stream "+(endTime - startTime)+" ms");

        startTime = System.currentTimeMillis();
        factorialList = listInteger.parallelStream().map(ParallelStream::factorial).collect(Collectors.toList());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with Parallel stream "+(endTime-startTime)+" ms");

        //Parallel streams are most effective for CPU-intensive or large datasets where tasks are independent .
        //They may add overhead for simple tasks or small datasets.


        //Cumulative sum
        List<Integer> number=Arrays.asList(1, 2, 3, 4, 5);
//        int total = 0; //sum
//        List<Integer> cumulativeSum = number.parallelStream().map(x -> {
//            return total += x;
//        }).toList();

        AtomicInteger total = new AtomicInteger(0);
        List<Integer> cumulativeSum = number.parallelStream().map(x -> total.addAndGet(x)).toList();
        System.out.println(cumulativeSum); // incorrect result

        //sequential() --> to covert parallel stream to sequential




        //Collectors

        //Collectors is a utility class
        //provides a set of methods to create common collectors

        // 1. Collecting to a List
        List<String> list1 = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> collectList = list1.stream()
                .filter(str -> str.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(collectList);

        // 2. Collecting to a Set
        List<Integer> nums1 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        System.out.println(set);
        
        // 3. Collecting to a Specific Collection
        ArrayDeque<String> collect1 = list1.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        //4. Joining Strings
        // Concatenates stream element into a single string
        String collect2 = list1.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(collect2);

        // 5. Summarizing Data
        //Generates statistical summary (count, sum, min, average, max)

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        IntSummaryStatistics stats = numbers1.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());

        //6. Averaging
        Double average = numbers1.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average: " + average);

        //7. counting
        Long counting = numbers1.stream().collect(Collectors.counting());
        System.out.println("Count: " + counting);

        //8. groupingBy
        List<String> words = Arrays.asList("Java", "Hello", "World", "Collecting");
        Map<Integer, List<String>> map = words.stream().collect(Collectors.groupingBy(str -> str.length()));
        System.out.println(map);

        Map<Integer, String> collect3 = words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(" ")));
        System.out.println(collect3);

        Map<Integer, Long> collect4 = words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(collect4);

        TreeMap<Integer, Long> collect5 = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(collect5);

        // 9. Partitioning Elements
        // Partitions elements into two groups (true or false) based on a predicate.
        Map<Boolean, List<String>> collect6 = words.stream().collect(Collectors.partitioningBy(str -> str.length() > 5));
        System.out.println(collect6);

        // 10. Mapping and Collecting
        // Applies a mapping function before collecting

        List<String> collect7 = words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList()));
        System.out.println(collect7);


        //Example 1: Collecting Names By length
        List<String> l1 = Arrays.asList("Anna", "Bob", "Alexander", "Brain", "Alice");
        Map<Integer,List<String>> listMap = l1.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(listMap);

        //Example 2: Counting Word Occurrences
        String sentance = "hello world hello java world";
        Map<String, Long> countWords = Arrays.stream(sentance.split(" ")).collect(Collectors.groupingBy(str -> str, Collectors.counting()));
        System.out.println(countWords);

        //Example 3: Partitioning Even and Odd Numbers
        List<Integer> listInteger1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<Boolean, List<Integer>> collect8 = listInteger1.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(collect8);

        //Example 4: Summing values in a Map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 15);

        Optional<Integer> reduce = items.values().stream().reduce(Integer::sum);
        reduce.ifPresent(System.out::println);

        Integer totalSum = items.values().stream().collect(Collectors.summingInt(x -> x));
        System.out.println(totalSum);

        //Example 5: Creating a Map from Stream Elements
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        Map<Integer, List<String>> mapFruits = fruits.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(mapFruits);

        Map<String, Integer> stringIntegerMap = fruits.stream().collect(Collectors.toMap(s -> s.toUpperCase(), s -> s.length()));
        System.out.println(stringIntegerMap);

        //Example 6: toMap(key, value, merge function)
        List<String> word2 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> stringLongMap = word2.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(stringLongMap);

        Map<String, Integer> stringIntegerMap1 = word2.stream().collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x + y));
        System.out.println(stringIntegerMap1);







        //Primitive Stream

        int[] arr = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(arr);

        List<Integer> integerList1 = IntStream.range(1, 5).boxed().collect(Collectors.toList());
        System.out.println(integerList1);

        DoubleStream doubles = new Random().doubles(5);
        System.out.println(doubles.boxed().collect(Collectors.toList()));

        IntStream ints = new Random().ints(5);
        System.out.println(ints.boxed().collect(Collectors.toList()));
    }
}

class ParallelStream{
    public static int factorial(int number){
        if(number == 0 || number ==1){
            return 1;
        }

        return number*factorial(number-1);
    }
}
