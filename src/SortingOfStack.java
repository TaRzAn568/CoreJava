import java.util.Scanner;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/sort-a-stack/1
public class SortingOfStack{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Stack<Integer> s=new Stack<>();
            int n=sc.nextInt();
            while(n-->0)
                s.push(sc.nextInt());
            MAinClassForSortingOfStack g=new MAinClassForSortingOfStack();
            //Stack<Integer> a=g.sortStacktBruteForce(s);
            Stack<Integer> a = g.sortStackUsingNewStack(s);
            while(!a.empty()){
                System.out.print(a.peek()+" ");
                a.pop();
            }
            System.out.println();
        }
    }
}
/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
class MAinClassForSortingOfStack{
    //bruteForce Approach
    public Stack<Integer> sortStacktBruteForce(Stack<Integer> s)
    {   int n = s.size();
        for(int j=0; j<n; j++){
            int max = -1;
            int pos = -1;
            for(int i=n-j-1; i>=0; i--){
                if(s.get(i) > max){
                    max = s.get(i);
                    pos = i;
                }
            }
            int temp = s.get(n-j-1);
            s.remove(n-j-1);
            s.add(n-j-1,max);
            s.remove(pos);
            s.add(pos,temp);
        }
        return s;
    }
    //using new stack taking min value which depends on constraints
    public Stack sortStackUsingNewStack(Stack<Integer> s){
        // chosing min depends on constraints
        int n = s.size();
        Stack s1 = new Stack();
        for(int j=0; j<n; j++) {
            int pos = -1;
            int min = 101;
            for (int i = s.size() - 1; i >= 0; i--) {
                if (s.get(i) < min) {
                    min = s.get(i);
                    pos = i;
                }
            }
            s.remove(pos);
            s1.push(min);
        }
        return s1;
    }
//Sorting a stack using currency(Coin) sorting problem
    public Stack sortUsingCurrencySolution(Stack<Integer> s){
        Stack<Integer> s1 = new Stack<Integer>();
        int topS = 0;
        if(s == null || s.isEmpty()){
            return null;
        }
        while(!s.isEmpty()){
            topS =s.pop();
            while(!s1.isEmpty() && s1.peek()>topS){
                s.push(s1.pop());
            }
            s1.push(topS);
        }
        return s1;
    }
}