package LambdaExpressionCollection;

import java.util.TreeSet;

public class LambdaExpressionCollection2 {
    public static void main(String[] args)
    {
        //Customized sorting order with lambda expression
        TreeSet<Integer> t = new TreeSet<Integer>((I1,I2)->(I1>I2)?-1:(I1<I2)?1:0);
        t.add(10);
        t.add(0);
        t.add(25);
        t.add(5);
        t.add(20);
        System.out.println(t);
    }
}
