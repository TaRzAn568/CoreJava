package StringUtils;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmallestWindowOfCommonString {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            String res = getSmallestWindowCommonString(s1,s1.length(),s2,s2.length());
            System.out.println(res);
        }
    }

    public static String getSmallestWindowCommonString(String s1, int n1, String s2, int n2){
        Map<Character,Integer> s2map = new HashMap<>();
        for(Character x : s2.toCharArray())
            s2map.put(x,s2map.getOrDefault(x,0)+1);

        int sum = s2.length();
        int temp = 0;
        int left = 0;
        int right = 0;
        int bestL = 0;
        int bestR = 0;
        int bestLen = Integer.MAX_VALUE;
        for(int i=0; i<s1.length(); i++){
            char ichar = s1.charAt(i);
            if(s2.contains(s1.substring(i,i+1))){
                if(s2map.get(ichar) > 0 ) {
                    sum--;
                }
                s2map.put(ichar,s2map.get(ichar)-1);
                if(sum == 0){
                    right = i;
                    for(int j=left; j<=right; j++){
                        char jChar = s1.charAt(j);
                        if(!s2map.containsKey(jChar)){
                            continue;
                        }else {
                            if (s2map.getOrDefault(jChar, 0) < 0) {
                                s2map.put(jChar, s2map.getOrDefault(jChar, 0) + 1);
                            } else {
                                left = j;
                                break;
                            }
                        }
                    }
                    if(right - left < bestLen) {
                        bestL = left;
                        bestR = right;
                        bestLen = right - left;
                    }

                    s2map.put(s1.charAt(left),s2map.getOrDefault(s1.charAt(left),0)+1);
                    sum++;
                    left++;
                }
            }
        }
        return s1.substring(bestL,bestR+1);
    }

}
