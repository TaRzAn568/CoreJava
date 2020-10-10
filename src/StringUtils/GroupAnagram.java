package StringUtils;

import java.util.*;
import java.lang.*;
import java.io.*;

class GroupAnagram {
    public static void main(String[] ajd)throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            List<Integer>  res = groupAnagram(s.split("\\s"),n);
            for(int x : res){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        br.close();
    }

    public static List<Integer> groupAnagram(String[] s, int n){
        boolean visited[] = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n ; i++) {
            int count = 1;
            if (!visited[i]){
                for (int j = i + 1; j < n; j++) {
                    if (!visited[j]) {

                        boolean flag = checkAnagram(s[i], s[j]);
                        if (flag) {
                            count += 1;
                            visited[j] = true;
                        }
                    }
                }
                res.add(count);
            }
        }
        Collections.sort(res);
        return res;
    }
    public static boolean checkAnagram(String s1, String s2){
        boolean res = true;
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 != n2) return !res;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<n1; i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        int c = 0;
        for(int i=0; i<n2; i++){
            char iChar = s2.charAt(i);
            if(map.getOrDefault(iChar,0) > 0){
                map.put(iChar,map.getOrDefault(iChar,0)-1);
                c++;
            }else{
                res = false;
                break;
            }
        }
        if(c != n1)
            res = false;

        return res;


    }

}