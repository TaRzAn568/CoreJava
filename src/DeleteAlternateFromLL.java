// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

/*class SingleLLNode {
    int data;
    SingleLLNode next;

    public SingleLLNode(int data){
        this.data = data;
    }
}*/

class DeleteAlternateFromLL {

    public static void po(Object o){
        System.out.println(o);
    }

    public static void show(SingleLLNode head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){

            SingleLLNode head1 = null,tail1 = null;

            int n1 = sc.nextInt();
            int d1 = sc.nextInt();
            head1 = new SingleLLNode(d1);
            tail1 = head1;

            while(n1-- > 1){
                tail1.next = new SingleLLNode(sc.nextInt());
                tail1 = tail1.next;
            }

            DeleteAlternateFromLLSolution obj = new DeleteAlternateFromLLSolution();
            obj.deleteAlternate(head1);
            System.out.println();
        }
    }

}

// } Driver Code Ends



/*
class SingleLLNode {
    int data;
    SingleLLNode next;

    public SingleLLNode(int data){
        this.data = data;
    }
}
*/
class DeleteAlternateFromLLSolution {

    public void deleteAlternate (SingleLLNode head){
        SingleLLNode temp = head;
        while(temp != null && temp.next != null){
            temp.next = temp.next.next;
            temp = temp.next;
        }
        printLL(head);
    }
    void printLL(SingleLLNode head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}

