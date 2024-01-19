package LambdaExpression;

interface Interf4
{
    public int squareIt(int x);
}
public class LambdaExpression4 {
    public static void main(String[] args)
    {
        //with lambda expression---> no need of implementaton class 
        Interf4 i=x -> x*x;
        System.out.println(i.squareIt(4));
        System.out.println(i.squareIt(5));
    }
}
