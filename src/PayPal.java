
import java.util.*;
import java.util.Arrays;

public class PayPal {

    public static void main(String[] args){

        int sum = 2444;
        int n = 94;
        // 26^9
        if(sum == 0){
            System.out.println();
        }
        else if(sum < 0 || n < 0 || (sum > (26*n) || (sum < n))){
            System.out.println("Invalid input");
        }
        else {
            char[] res = getSmallestString(n,sum);
            System.out.println(new String(res));

            /*char[] curr = new char[n];
            Arrays.fill(curr, '$');
            List<String> res = new ArrayList<>();
            getAllStringsInLexicographicalOrder(sum, n, 0, curr, res);
            System.out.println(res);*/
        }
    }



    // this method will just return the first lexicographically smallest string
        public static char[] getSmallestString(int n, int sum)
        {
            char a[] = new char[n];
            Arrays.fill(a, 'a');
            // we will start from the end of the char array as we wanted to make lexicographically smallest string
            for (int i = n - 1; i >= 0; i--) {
                sum = sum - i;
                if (sum >= 0) {
                    if (sum > 27) {
                        a[i] = 'z';
                        sum = sum - 26;
                    }
                    else {
                        a[i] = (char)(sum - 1 + 'a');
                        sum = (sum - (a[i] - 'a' + 1));
                    }
                }
                else {
                    break;
                }
                sum += i;
            }
            return a;
        }




    // this method will return all the desired string in lexicographical order
    static void getAllStringsInLexicographicalOrder(int sum, int n, int i,char[] curr, List<String> res){
        if(sum < 0){
            return;
        }
        if(i == n){
            if(sum == 0) {
                res.add(new String(curr));
            }
            return;
        }
        for(int ch = 1; ch <=26; ch++){
            curr[i] = (char)(ch-1 + 'a');
            getAllStringsInLexicographicalOrder(sum-ch, n, i+1,curr, res);
            curr[i] = '$';
        }
    }

}
