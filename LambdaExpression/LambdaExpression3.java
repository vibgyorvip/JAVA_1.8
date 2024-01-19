package LambdaExpression;

interface Interf3
{
    public int getLength(String s);
}

class Demo3 implements Interf3
{
    @Override
    public int getLength(String s) {
        return s.length();
    }
}
public class LambdaExpression3 {
    public static void main(String[] args)
    {
        //Interf3 i=new Demo3();
        //with lambda expression
        Interf3 i=s -> s.length();
        System.out.println(i.getLength("Vipul"));
        System.out.println(i.getLength("Agnihotri"));
    }
}
