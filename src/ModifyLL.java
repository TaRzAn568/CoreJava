// { Driver Code Starts

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

/*class singleLLNode {
    int data;
    singleLLNode next;

    public singleLLNode(int data){
        this.data = data;
        this.next = null;
    }
}*/

class ModifyLL {

    public static void po(Object o){
        System.out.println(o);
    }

    public static void show(singleLLNode head){
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

            singleLLNode head1 = null,tail1 = null;

            int n1 = sc.nextInt();
            int d1 = sc.nextInt();
            head1 = new singleLLNode(d1);
            tail1 = head1;

            while(n1-- > 1){
                singleLLNode n = new singleLLNode(sc.nextInt());
                n.next = head1;
                head1 = n;
            }

            ModifyLLSolution obj = new ModifyLLSolution();
            head1 = obj.modify(head1);
            obj.show(head1);
            System.out.println();
        }
    }

}// } Driver Code Ends



/*
class singleLLNode {
    int data;
    singleLLNode next;
    
    public singleLLNode(int data){
        this.data = data;
        this.next = null;
    }
}
*/

class ModifyLLSolution {
    public static void show(singleLLNode head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public singleLLNode modify(singleLLNode head){

        singleLLNode temp = head;
        fun(head,temp,1, false);
        return temp;
    }

    static singleLLNode h2 = null;
    static int h2c = 1;
    public static void fun(singleLLNode h1, singleLLNode h3,int h1c, boolean res){
        if(h1 == null || res){
            return;
        }
        fun(h1.next,h3,++h1c,false);
        if(h2 == null){h2 = h3;}
        if(h2c < h1c-1){
            h2.data = h1.data-h2.data;
            h2 = h2.next;
            h2c++;
        }
    }
}