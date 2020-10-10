import java.util.*;


public class Test2 {
    public  static void main(String []djwj){
        int n = 1343433650;

        String res = getResult(n);
        System.out.println(res);

    }

    public static String getResult(int n){
        StringBuffer sb = new StringBuffer();
        while(n > 0){
            int rem = n % 26;
            sb.append((char)((rem-1)+ 'a'));
            n = n / 26;
        }

        return sb.reverse().toString();
    }
}
