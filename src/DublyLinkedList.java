// { Driver Code Starts
//Initial Template for Java
/*
https://practice.geeksforgeeks.org/problems/rotate-doubly-linked-list-by-p-nodes/1
*/
import java.util.*;
import java.io.*;

class Node3 {
    int data;
    Node3 prev, next;

    public Node3 (int d){
        this.data = d;
        prev = null;
        next = null;
    }
}

public class DublyLinkedList {

    static void display(Node3 Node3){
        while(Node3 != null){
            System.out.print(Node3.data+" ");
            Node3 = Node3.next;
        }
        System.out.println();
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int p = sc.nextInt();

            //Entering the data
            Node3 head = new Node3(sc.nextInt());
            Node3 curr = head;

            //Entering the rest of the list
            for(int i=0; i<n-1; i++){
                int d = sc.nextInt();
                Node3 newNode = new Node3(d);
                curr.next = newNode;
                newNode.prev = curr;
                curr = curr.next;
            }

            Utility obj = new Utility();
            display(obj.rotateP(head, p));
        }
    }

}
// } Driver Code Ends
//User function Template for Java

/*
class Node3 {
    int data;
    Node3 prev, next;
    
    public Node3 (int d){
        this.data = d;
        prev = null;
        next = null;
    }
}
*/

class Utility {
    /*Node3 rotateP (Node3 head, int p){
        while(p-->0){
            Node3 temp1 = head;
            Node3 temp2 = head.next;
            head = head.next;
            temp1.next = null;
            temp2.prev = null;
            while(temp2.next != null){
                temp2 = temp2.next;
            }
            temp2.next = temp1;
            temp1.prev = temp2;
        }
        return head;
    }*/
    Node3 rotateP (Node3 head, int p){
        Node3 temp1 = head;
        while(p-- > 0){
            head = head.next;
        }
        Node3 temp2 = head;
        temp2.prev.next = null;
        temp2.prev = null;

        while(temp2.next != null){
            temp2 = temp2.next;
        }
        temp2.next = temp1;
        temp1.prev = temp2;
        return head;
    }
}