import java.util.*;

public class Monster {

    //list = {​​​​​1, 9, 4, 3, 6,  5}​​​​​ => {}

    public static void main(String[] ad){
        int n = 3;

        int[] a = new int[]{1,1,1};

        int max = a[0];
        int sMax = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){

            if(max < a[i]){
                sMax = max;
                max = a[i];
            }
            else if(sMax < a[i]){
                sMax = a[i];
            }
        }
        System.out.println(sMax);

    }
}


