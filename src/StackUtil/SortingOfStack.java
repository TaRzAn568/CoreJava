import java.util.Scanner;
import java.util.Stack;
class SortingOfStack1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Stack<Integer> s=new Stack<>();
            int n=sc.nextInt();
            while(n-->0)
                s.push(sc.nextInt());
            SortingOfStack1Sol g=new SortingOfStack1Sol();
            Stack<Integer> a=g.sort(s);
            while(!a.empty()){
                System.out.print(a.peek()+" ");
                a.pop();
            }
            System.out.println();
        }
    }
}// } Driver Code Ends
/*Complete the function below*/
class SortingOfStack1Sol{
    public Stack<Integer> sort(Stack<Integer> s)
    {
       for(int i=s.size()-1; i>=0; i--){
           for(int j = s.size()-1; j>=s.size()-i; j--){
               if(s.get(j) < s.get(j-1)){
                   int temp = s.get(j);
                   s.remove(j);
                   s.add(j,s.get(j-1));
                   s.remove(j-1);
                   s.add(j-1,temp);
               }
           }
       }
        return s;
    }
}