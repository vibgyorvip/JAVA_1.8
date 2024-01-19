package LambdaExpressionCollection;

import java.util.TreeMap;

public class LambdaExpressionCollection3 {
    public static void main(String[] args)
    {
        //customized sorting order with lambda expression
        TreeMap<Integer,String> m=new TreeMap<Integer,String>((I1,I2)->(I1>I2)?-1:(I1<I2)?1:0);
        m.put(100,"Vipul");
        m.put(600,"Sunny");
        m.put(300,"Bunny");
        m.put(200,"Chinny");
        System.out.println(m);
    }
}
