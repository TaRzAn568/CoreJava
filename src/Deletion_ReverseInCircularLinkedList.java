import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//https://practice.geeksforgeeks.org/problems/deletion-and-reverse-in-linked-list/1
class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;
        next=null;
    }
}

public class Deletion_ReverseInCircularLinkedList {
    public static void printList(Node head)
    {
        Node start=head;
        System.out.print(head.data+" ");
        head=head.next;
        while(head!=start)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node start = null, cur = null;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                Node ptr = new Node(a);
                if (start == null) {
                    start = ptr;
                    cur = ptr;
                } else {
                    cur.next = ptr;
                    cur = ptr;
                }
            }
            int delNode = sc.nextInt();
            cur.next = start;
            Deletion_ReverseInCircularLinkedList obj = new Deletion_ReverseInCircularLinkedList();
            Node head = obj.deleteNode(start, delNode);
            start = obj.reverse(head);
            printList(start);
        }
    }
    public Node deleteNode(Node head, int d){
        Node temp = head;
        while(true){
            if(temp.next.data == d)
            {
                temp.next = temp.next.next;
                break;
            }
            else
            {
                temp = temp.next;
            }
        }
        while(true){
            if(temp == head){
                break;
            }
            else{
                temp = temp.next;
            }
        }
        return temp;
    }
    public Node reverse(Node head){
        Stack<Node> s = new Stack<Node>();
        Node temp = head;
        s.push(temp);
        temp = temp.next;
        while(temp != head) {
            s.push(temp);
            temp = temp.next;
        }
        Node head2 = s.pop();
        Node temp2 = head2;

        while(!s.empty()){
            temp2.next = s.pop();
            temp2 = temp2.next;
        }
        temp2.next = head2;
        System.out.println("head2 = "+head2);
        s.pop();
        return head2;
    }
}