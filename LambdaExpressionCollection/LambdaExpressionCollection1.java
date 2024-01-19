package LambdaExpressionCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyComprator implements Comparator<Integer>
{
    @Override
    public int compare(Integer I1, Integer I2) {
        if(I1>I2) return -1;
        else if(I1<I2) return +1;
        else return 0;
        // return (I1>I2)?-1:(I1<I2)?1:0 ;
    }
}
public class LambdaExpressionCollection1 {
    public static void main(String[] args)
    {
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(10);
        l.add(0);
        l.add(15);
        l.add(5);
        l.add(20);
        System.out.println("Before sorting: "+l);
        //Collections.sort(l,new MyComprator());
        //lambda expression
        Collections.sort(l,(I1,I2)->(I1>I2)?-1:(I1<I2)?1:0);
        System.out.println("After sorting: "+l);
    }
}
