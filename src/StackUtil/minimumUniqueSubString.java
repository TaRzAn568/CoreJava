import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class minimumUniqueSubStringSol {

    /*
     * Complete the 'fewestCoins' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING coins as parameter.
     */

    public static int fewestCoins(String coins) {
        //int res = 0;
        Map<Character,Integer> m = new HashMap<>();
        for(char c : coins.toCharArray()){
            m.put(c,m.getOrDefault(c, 0)+1);
        }
        int left = 0;
        int right = 0;
        System.out.println(m);
        System.out.println(right+" size");

        int c = 0;
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> m2 = new HashMap<>();
        for(int i=0;i<coins.length();i++){
            if(m.getOrDefault(coins.charAt(i),0)>0)
            {
                m2.put(coins.charAt(i),m2.getOrDefault(coins.charAt(i), 0)+1);
                if(m2.size() == m.size()){
                    right = i;
                while(m2.getOrDefault(coins.charAt(left),0)>1){
                    m2.put(coins.charAt(left),m2.getOrDefault(coins.charAt(left), 0)-1);
                    left++;

                }
                }
            }
            if(min > i-left+1){
                min = i-left+1;
            }
        }




        System.out.println(min);
        return right-left+1;
    }

}
public class minimumUniqueSubString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String coins = bufferedReader.readLine();

        int result = minimumUniqueSubStringSol.fewestCoins(coins);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        System.out.println(result);

        bufferedReader.close();
        //bufferedWriter.close();
    }
}