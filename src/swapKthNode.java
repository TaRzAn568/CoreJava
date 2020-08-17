
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
        import java.io.*;
        import java.lang.*;

/*
class SingleLLNode
{
    int data;
    SingleLLNode next;

    SingleLLNode(int data)
    {
        this.data = data;
        next = null;
    }
}
*/

class swapKthNode
{
    static  SingleLLNode head;
    static  SingleLLNode lastNode;

    public static void addToTheLast(SingleLLNode node)
    {

        if (head == null)
        {
            head = node;
            lastNode = node;
        }
        else
        {
            SingleLLNode temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }

    public static void main(String args[])
    {
        Scanner sc=  new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n, K;
            n = sc.nextInt();
            K = sc.nextInt();

            SingleLLNode head = null;
            int val = sc.nextInt();
            head = new SingleLLNode(val);
            addToTheLast(head);

            for(int i = 1; i< n; i++)
            {
                val = sc.nextInt();
                addToTheLast(new SingleLLNode(val));
            }

            SingleLLNode before[] = new SingleLLNode[n];
            addressstore(before, head);
            swapKthNodeSol obj = new swapKthNodeSol();

            head = obj.swapkthnode(head, n, K);

            SingleLLNode after[] = new SingleLLNode[n];
            addressstore(after, head);

            if(check(before, after, n, K) == true)
                System.out.println("1");
            else
                System.out.println("0");

        }
    }

    static boolean check(SingleLLNode before[], SingleLLNode after[], int num, int K)
    {
        if(K > num)
            return true;

        return (before[K-1] == after[num - K]) && (before[num-K] == after[K-1]);


    }

    static void addressstore(SingleLLNode arr[], SingleLLNode head)
    {
        SingleLLNode temp = head;
        int i = 0;
        while(temp != null){
            arr[i] = temp;
            i++;
            temp = temp.next;
        }
    }

}// } Driver Code Ends
//User function Template for Java


/* Linked List SingleLLNode class
   class SingleLLNode  {
     int data;
     SingleLLNode next;
     SingleLLNode(int data)
     {
         this.data = data;
         next = null;
     }
  }
*/
class swapKthNodeSol
{
    // Should swap Kth node from beginning and 
    // Kth node from end in list and return new head.
    SingleLLNode swapkthnode(SingleLLNode head, int n, int k)
    {
        if(head == null || head.next == null)
            return head;
        SingleLLNode front1 = null, front2 = null, back1 = null, back2 = null;
        SingleLLNode temp = head;
        int c = 1;
        if(k > n/2){
            k = n-k+1;
        }
        while(temp != null){
            if(c == k-1){
                front1 = temp;
            }
            if(c == k+1){
                front2 = temp;
            }if(c == n-k){
                back1 = temp;
            }if(c == n-k+2){
                back2 = temp;
            }
            temp = temp.next;
            c++;
        }
        if(k>1 && back1 != null && front1 != null ){

            SingleLLNode temp1 = front1.next;
            temp1.next = null;
            front1.next = back1.next;
            front1.next.next = front2;
            back1.next = temp1;
            back1.next.next = back2;
        }
        else if(k == 1){
            head.next = null;
            SingleLLNode temp2 = back1.next;
            back1.next = head;
            temp2.next = front2;
            head = temp2;
        }
        return head;
    }
}
