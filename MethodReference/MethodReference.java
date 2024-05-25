import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args)
    {
        List<String> names= Arrays.asList("Navin","Vipul","John");


        List<String> unames= names.stream()
                .map(String::toUpperCase)
                .toList();//covert stream to list

        //System.out.println(unames);
        //unames.forEach(n-> System.out.println(n));
          unames.forEach(System.out::println);



//        List<String> list= names.stream()
//                                .map(name -> name.toUpperCase())
//                                .toList();//covert stream to list
//
//        System.out.println(list);



    }
}
