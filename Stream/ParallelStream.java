import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStream {

    public static void main(String[] args) {
        int size = 10_000;
        List<Integer> l = new ArrayList<>(size);

        Random ran = new Random();


        for (int i = 1; i <= size; i++) {
            l.add(ran.nextInt(100));
        }

        System.out.println(l);

//        int sum1=l.stream()
//                .map(n->n*2)
//                .reduce(0,(c,e)->c+e);

        long startSeq = System.currentTimeMillis();
        int sum2 = l.stream()
                .map(n -> {
                    try{
                        Thread.sleep(1);
                    }catch(Exception e) {
                    }
                    return n * 2;
                })
                .mapToInt(n -> n)
                .sum();
        long endSeq = System.currentTimeMillis();

        long startPara = System.currentTimeMillis();
        int sum3 = l.parallelStream()
                .map(n -> {
                    try{
                        Thread.sleep(1);
                    }catch(Exception e) {
                    }
                    return n * 2;
                })
                .mapToInt(n -> n)
                .sum();
        long endPara = System.currentTimeMillis();

        System.out.println(sum2 + " " + sum3);
        System.out.println("Seq :" + (endSeq - startSeq));
        System.out.println("Para :" + (endPara - startPara));
    }
}
