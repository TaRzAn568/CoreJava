package StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

class MyComrator implements Comparator<String> {
    public int compare(String s1, String s2){
        Map<Character, Integer> map = new HashMap<>();
        String pat = new CustomSort().pat;      //"qwertyuiopasdfghjklzxcvbnm"
        for(int i=0; i<pat.length(); i++ )
            map.put(pat.charAt(i), i);

        int lim = Math.min(s1.length(), s2.length());
        int k = 0;
        while(k < lim){
            char c1 = s1.charAt(k);
            char c2 = s2.charAt(k);
            if(c1 != c2){
                return map.get(c1) - map.get(c2);
            }
            k++;
        }
        return s1.length() - s2.length();
    }


}

class CharComrator implements Comparator<Character> {
    public int compare(Character s1, Character s2){
        Map<Character, Integer> map = new HashMap<>();
        String pat = new CustomSort().pat;      //"qwertyuiopasdfghjklzxcvbnm"
        for(int i=0; i<pat.length(); i++ )
            map.put(pat.charAt(i), i);

        return map.get(s1) - map.get(s2);
    }


}


public class CustomSort {
    //public final String pat = "qwertyuiopasdfghjklzxcvbnm";
    public final String pat = "wcyuogmlrdfphitxjakqvzbnes";

    public static void main(String[] args) {
        String[] strs = new String[]{"ved", "raj", "alok", "lokesh", "kapil", "ajay"};
        String[] naturalSorted = strs.clone();

        MyComrator cmp = new MyComrator();
        Arrays.sort(naturalSorted, cmp);

        for(String x : naturalSorted)
        System.out.print(x+" ,");

        System.out.println();

        String s = "jcdokai";
        Character[] sarr = new Character[s.length()];
        for(int i=0; i<s.length(); i++)
            sarr[i] = s.charAt(i);
        Arrays.sort(sarr, new CharComrator());

        char[] out = new char[s.length()];
        for(int i=0; i<s.length(); i++)
            out[i] = sarr[i].charValue();

        System.out.print(new String(out));

    }
}
