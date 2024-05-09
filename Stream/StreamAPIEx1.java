import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StreamAPIEx1 {
    public static void main(String [] args)
    {
        List<Integer> nums = Arrays.asList(4,5,7,3,2,6);


        Consumer<Integer> con = new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        };

        nums.forEach(con);

        //nums.forEach(n-> System.out.println(n)); // using lambda expression

//        for(int i=0;i<nums.size();i++)
//        {
//            System.out.println(nums.get(i));
//        }

//        for(int n : nums)
//        {
//            System.out.println(n);
//        }

//        int sum=0;
//        for(int n : nums)
//        {
//            if(n%2==0)
//            {
//                n=n*2;
//                sum = sum + n;
//            }
//        }
//        System.out.println(sum);

    }
}
