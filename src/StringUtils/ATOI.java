package StringUtils;
import java.io.*;

public class ATOI {
 public static void main(String[] args)throws IOException{
     String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
     System.out.println(new ATOISolution().myAtoi(s));
 }
}


class ATOISolution {
    public int myAtoi(String s) {

        StringBuffer res = new StringBuffer();

        char [] a = s.trim().toCharArray();
        for(int i=0;i<a.length; i++){

            if(i == 0 && !((a[i] >= '0' && a[i] <='9') || (a[i] == '-' || a[i] == '+'))){
                break;
            }else if(i != 0 && (!(a[i] >= '0' && a[i] <='9'))){
                break;
            }
            else{
                res.append(a[i]);
            }
        }
        String max = Integer.toString((Integer.MAX_VALUE));
        String min = Integer.toString((Integer.MIN_VALUE));
        if(res.indexOf("-")==0){

            if(  res.substring(1).toString().compareTo(min.substring(1)) >= 1){
                res = new StringBuffer(min);
            }
        }
        else{
            if(res.indexOf("+") == 0){
                if(res.substring(1).toString().compareTo(max) >= 1){
                    res = new StringBuffer(max);
                }
            }else{
                if(res.toString().compareTo(max) >= 1){
                    res = new StringBuffer(max);
                }
            }

        }



        int val = res.length() == 0 ? 0 :Integer.parseInt(res.toString());

        return val;
    }
}