package LinkedList;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
    public class SingleLL {
        static Node head = null;

        public static void main(String[] args) {
        // SL req
 /*
    addNode(head, data);
    deleteNode(head, data);
    printLL(head);

 */

        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(5);
        //head = addNode(head, 3);
        //head = addNode(head, 4);

        printLL();
        deleteNode(5);
        System.out.println();
            printLL();


    }
    static void addNode(int data){
        if(head == null){
            Node temp = new Node(data);
            head = temp;
            System.out.println("Here");
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }

    static void deleteNode(int data){
        if(head == null)
        {
            return ;
        }
        Node temp = head;
        while(temp.next != null ){
            if(temp.next.data == data){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    static void printLL(){
        Node temp = head;
        while(temp != null){

            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

}
