import java.util.*;

public class MSR1 {

    public static void main(String [] ars){
        int[] temperature_arr = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        //int output [] = daysToWarmerDay(temperature_arr);
        /*
        for(int day : output){
            System.out.print(day+" ");
        }*/

        System.out.println(pairity(132));


    }

    static int[] daysToWarmerDay(int [] temperature_arr){
        Stack<Integer> stack = new Stack<>();
        int n = temperature_arr.length;
        int [] output = new int[n];
        stack.push(n-1);

        for(int i = n-2; i >= 0; i--){
            while(!stack.empty() && temperature_arr[stack.peek()] <= temperature_arr[i]){
                stack.pop();
            }
            output[i] = stack.isEmpty() ? 0 : stack.peek() - i ;
            stack.push(i);
        }
        return output;
    }


    static int pairity(long n){

        System.out.println(Long.toBinaryString(n));
        int ans = 0;
        while(n > 0){
            if((n&1) == 1){
                ans += 1;
            }
            n = n>>1;
        }
        return (ans&1) == 1 ? 1 : 0 ;
    }
}


