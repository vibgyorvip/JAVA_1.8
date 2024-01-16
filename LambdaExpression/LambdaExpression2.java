package LambdaExpression;

interface Interf2
{
    public void add(int a, int b);
}
class Demo2 implements Interf2
{
    @Override
    public void add(int a, int b) {
        System.out.println("The sum : "+(a+b));
    }
}
public class LambdaExpression2 {
   public static void main(String[] args)
   {
       //Interf2 i= new Demo2();
       //with lambda expression
       Interf2 i = (a,b)->System.out.println("The sum : "+(a+b));
       i.add(10,20);
       i.add(100,200);
   }

}
