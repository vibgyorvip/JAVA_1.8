package LambdaExpression;

class MyRunnable implements Runnable
{
    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            //Executed by Child Thread
            System.out.println("Child Thread");
        }
    }
}
public class LambdaExpression5 {
    public static void main(String[] args)
    {
        //Runnable r = new MyRunnable();
        //Lambda expression
        Runnable r = ()->{ for(int i=0; i<10; i++)
                            {
                                System.out.println("Child Thread");
                            }
                         };

        Thread t= new Thread(r);
        t.start();

        for (int i=0;i<10;i++)
        {
            //Excuted by main Thread
            System.out.println("Main Thread");
        }
    }
}
