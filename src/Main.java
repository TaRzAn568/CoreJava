
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Main{
    public static void main (String[] args)throws IOException {
        ConvertToInteger obj = new ConvertToInteger();
        obj.convertToInteger();
    }
}
//1abc2x30yz67
class ConvertToInteger {
    public void convertToInteger()throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t =  Integer.parseInt(br.readLine());
        List<BigInteger> resultList = new ArrayList<BigInteger>();
        while(t>0){
            String s = br.readLine();
            int i = 0;
            int j = i;
            BigInteger bg = new BigInteger("0");
            while(j <= s.length()){
                try{
                    if(j < s.length() && Character.isDigit(s.charAt(j))){
                        j++;
                        continue;
                    }
                    else if(j == s.length() && i<j){
                        bg = bg.add(new BigInteger(s.substring(i,j)));
                        break;
                    }
                    else{
                        if(i<j){
                            bg = bg.add(new BigInteger(s.substring(i,j)));
                        }
                        j++;
                        i = j;
                    }
                }catch (Exception e){
                    System.out.println("Exception for i = "+ i + " j = "+ j +" " + e);
                }
            }
            resultList.add(bg);
            t--;
        }
        for(BigInteger x : resultList){
            System.out.println(x);
        }

    }
}

