package LambdaExpression;

interface Interf
{
    public void m1();
}
class Demo implements Interf
{
    @Override
    public void m1() {
        System.out.println("m1() method implementation");
    }
}
public class LambdaExpression1 {
    public static void main(String[] args)
    {

        //Interf i = new Demo();
        //with lambda expression
        Interf i=()->System.out.println("m1() method implementation");
        //whenever compiler came across this line,he will notice that you are using lambda expression
        // by holding Interf "i". Inside "Interf" only 1 method present . 
        // compiler can guess , these are the arguments to m1() method. 
        i.m1();
    }
}
