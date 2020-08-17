package StackUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberToExcelSheetColumn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n  = Integer.parseInt(br.readLine());

            String  res = getColumn(n);
            System.out.println(res);

        }
    }
    static String getColumn(int n){
        StringBuffer sb = new StringBuffer();

        while(n > 0){
            int rem = n % 26;
            if(rem == 0){
                rem = 26;
                n -= 26;
            }
            n /= 26;
            sb.append((char)(rem+64));
        }
        return sb.reverse().toString();

    }
}
