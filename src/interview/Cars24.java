package interview;

import java.util.*;
public class Cars24 {
    public static void main(String[] args){
        List<String> nums = new ArrayList<>();
        nums.add("3");
        nums.add("30");
        nums.add("34");
        nums.add("51");
        nums.add("9");
        Collections.sort(nums, (s1,s2)->Integer.parseInt(s2+s1) - (Integer.parseInt(s1+s2)));
        System.out.println(nums);

    }
}
