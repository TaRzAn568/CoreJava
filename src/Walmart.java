

import java.util.*;
class LinkedList{
    int data;
    LinkedList next;

    LinkedList(int data){
        this.data = data;
        this.next = null;
    }
    void add(LinkedList head,LinkedList tail,int x){
        if(head == null){
            head = new LinkedList(x);
            head.next = null;
            tail = head;

        }else{
            tail = new LinkedList(x);
            tail.next = null;

        }
    }
}

class Walmart{
    static LinkedList head;
    static LinkedList tail;
    public static void main(String[] args){

        //System.out.println("Hello");
        LinkedList list = new LinkedList(1);		//1->2->5->3->7
        head = list;
        tail = list;
        list.add(head,tail,2);
        list.add(head,tail,5);
        list.add(head,tail,3);
        list.add(head,tail,7);

        printList(list);

        //reverseList(lList);


    }

    static void printList(LinkedList root){
        LinkedList temp = root;
        while(temp.next != null){
            System.out.print(temp.data);
        }
        System.out.println();
    }
}