// https://practice.geeksforgeeks.org/problems/quick-sort-on-linked-list/1
import java.util.*;
import java.lang.*;

class LinkedListNode
{
    int data;
    LinkedListNode next;
    LinkedListNode(int key)
    {
        data = key;
        next = null;
    }
}

class QuickSortOnLLMain
{
    static LinkedListNode head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            LinkedListNode head = new LinkedListNode(a1);
            addToTheLast(head);

            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new LinkedListNode(a));
            }

            QuickSortLL gfg = new QuickSortLL();
            LinkedListNode node = gfg.quickSort(head);

            printList(node);
            System.out.println();
        }
    }
    public static void printList(LinkedListNode head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(LinkedListNode node)
    {
        if (head == null)
        {
            head = node;
        } else
        {
            LinkedListNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
}// } Driver Code Ends
/*node class of the linked list
class LinkedListNode
{
    int data;
    LinkedListNode next;
    LinkedListNode(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function
class QuickSortLL
{
    public static LinkedListNode quickSort(LinkedListNode node)
    {
        LinkedListNode end = node;
        LinkedListNode head = node;
        while(end.next != null){
            end = end.next;
        }
        return doQuickSort(node, head, end);
    }
    public static LinkedListNode doQuickSort(LinkedListNode root, LinkedListNode head, LinkedListNode end){

        if(head != null && end != null  && head != end) {
            LinkedListNode pivotPointer = partition(head, end);
            doQuickSort(root, head, pivotPointer);
            if(pivotPointer == head && pivotPointer.next !=null){
                doQuickSort(root, pivotPointer.next, end);
            }
            else if (pivotPointer != null && pivotPointer.next != null && pivotPointer.next != end ){
                doQuickSort(root, pivotPointer.next.next, end);
            }
        }
        return root;
    }
    public static LinkedListNode partition(LinkedListNode head, LinkedListNode end){
        LinkedListNode pivot = end;
        LinkedListNode iPointer = null;
        LinkedListNode jPointer = head;
        while(jPointer != end){
            if(jPointer.data < pivot.data){
                if(iPointer == null){
                    iPointer = head;
                }else{
                    iPointer = iPointer.next;
                }
                int temp = iPointer.data;
                iPointer.data = jPointer.data;
                jPointer.data = temp;
            }
            jPointer = jPointer.next;
        }
        if(iPointer == null) {
            iPointer = head;
            int temp = head.data;
            head.data = pivot.data;
            pivot.data = temp;
            return iPointer;
        }
        int temp = iPointer.next.data;
        iPointer.next.data = pivot.data;
        pivot.data = temp;
        return iPointer;
    }
}