import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterNumber {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i] = Integer.parseInt(s[i]);
            }
            int[] res = getNextGreaterNumber(a,n);
            for(int x : res)
                System.out.print(x+" ");
            System.out.println();
        }
    }
    public static int[] getNextGreaterNumber(int[] a, int n){
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(st.empty() || a[st.peek()] > a[i]){
                st.push(i);
            }
            else{
                while(!st.empty() && a[st.peek()] < a[i]){
                    int top = st.pop();
                    res[top] = a[i];
                }
                st.push(i);
            }
        }
        while(!st.empty()){
            res[st.pop()] = -1;
        }
        return res;
    }

}
