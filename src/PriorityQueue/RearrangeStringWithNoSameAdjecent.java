package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*https://practice.geeksforgeeks.org/problems/rearrange-characters/0*/
public class RearrangeStringWithNoSameAdjecent {

    public static void main(String[] ajd)throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            String s = br.readLine();
            System.out.println(reArrangeString(s.toCharArray(),s.length()));
        }
        br.close();
    }

    public static int reArrangeString(char[] a, int n){
        PriorityQueue<Key> pq = new PriorityQueue<>(new keyComprator());
        int hash[] = new int[26];
        for (char x : a){
            hash[x-'a']++;
        }

        for(int i=0; i<26; i++){

            if(hash[i] > 0)
            pq.add(new Key((char)(i+(int)'a'), hash[i]));
        }
        /*while(pq.size() > 0)
        {
            System.out.print(pq.peek().val +" "+pq.poll().count);
        }*/
        String res = "";
        Key prev = null;
        while(pq.size() > 0)
        {
            Key k = pq.peek();
            pq.poll();
            res += k.val;
            k.count--;


            if(prev != null && prev.count > 0) {
                pq.add(prev);
            }
            prev = k;

        }

        System.out.println(res);
        return res.length() < n ? 0 :1;
    }
    static class Key{
        int count;
        char val;
        Key(char val, int count){
            this.val = val;
            this.count = count;
        }
    }
   static class keyComprator implements Comparator<Key>{
        public int compare(Key k1, Key k2){
            return k1.count > k2.count ? -1 : 1;
        }
    }

}
