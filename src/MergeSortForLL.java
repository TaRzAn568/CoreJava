

import java.util.*;
        import java.lang.*;
        import java.io.*;
/*
class singleLLNode
{
    int data;
    singleLLNode next;
    singleLLNode(int key)
    {
        data = key;
        next = null;
    }
}*/

class MergeSortForLL
{

    public static void main (String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            singleLLNode head = new singleLLNode(sc.nextInt());
            singleLLNode tail = head;
            while(n-- > 1){
                tail.next = new singleLLNode(sc.nextInt());
                tail = tail.next;
            }

            head = new MergeSortForLLSol().mergeSort(head);
            printList(head);
            System.out.println();
        }
    }
    public static void printList(singleLLNode head)
    {
        if(head == null)
            return;

        singleLLNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends
//User function Template for Java
/*
class singleLLNode
{
    int data;
    singleLLNode next;
    singleLLNode(int key)
    {
        this.data = key;
        next = null;
    }
} */

class MergeSortForLLSol
{   static singleLLNode res = null;
    static singleLLNode rTemp = null;
    static singleLLNode mergeSort(singleLLNode head)
    {
        if(head == null || head.next == null) return head;



        return sort(head);
    }
    public static singleLLNode getMid(singleLLNode head){
        if(head == null ) return head;
        singleLLNode s = head;
        singleLLNode f = head;
        while (f!=null && f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public static singleLLNode sort(singleLLNode head){
        if(head == null || head.next == null) return head;

        singleLLNode mid = getMid(head);
        singleLLNode nextOfMid = mid.next;
        mid.next = null;



        singleLLNode left = sort(head);
        singleLLNode right = sort(nextOfMid);

        singleLLNode res1 = sortedMerge(left, right);

        return res1;

    }
    static singleLLNode sortedMerge(singleLLNode a, singleLLNode b)
    {
        singleLLNode result = null; 
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a; 
  
        /* Pick either a or b, and recur */
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

   
}



