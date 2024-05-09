import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPIEx4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 7, 3, 2, 6);

//        Stream<Integer> s1 = list.stream();
//        Stream<Integer> s2 = s1.filter(n->n%2==0);
//        Stream<Integer> s3 = s2.sorted();

        Stream<Integer> s3 = list.stream()
                .filter(n -> n % 2 == 0)
                .sorted();

        s3.forEach(n -> System.out.println(n));
    }
}
