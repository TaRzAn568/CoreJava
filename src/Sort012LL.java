import java.util.*;
import java.lang.*;
import java.io.*;

/*class singleLLNode
{
    int data;
    singleLLNode next;
    singleLLNode(int key)
    {
        data = key;
        next = null;
    }
}*/

class Sort012LL
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

            head = new Sort012LLSol().segregate(head);
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
    singleLLNode(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Sort012LLSol
{
    static singleLLNode segregate(singleLLNode head)
    {
        singleLLNode zero = null;
        singleLLNode one = null,fOne = null;
        singleLLNode two = null,fTwo = null;
        singleLLNode res = null;
        while(head != null){
            switch(head.data){
                case 0:
                    if(zero == null){
                        zero = head;
                        res = head;
                        head = head.next;
                        res.next = null;
                    }
                    else{
                        zero.next = head;
                        zero = zero.next;
                        head = head.next;
                    }
                    break;
                case 1:
                    if(one == null){
                        one = head;
                        fOne = head;
                        head = head.next;
                        fOne.next = null;
                    }else{
                        one.next = head;
                        one = one.next;
                        head = head.next;
                    }
                    break;
                case 2:
                    if(two == null){
                        two = head;
                        fTwo = head;
                        head = head.next;
                        fTwo.next = null;
                    }
                    else{
                        two.next = head;
                        two = two.next;
                        head = head.next;
                    }
                    break;

            }
        }
        if(two != null) two.next = null;
        if(res == null){
            if(fOne != null){
                res = fOne;
                one.next = fTwo;
            }else{
                res = fTwo;
            }
        }else{
            if(fOne == null){
                zero.next = fTwo;
            }
            else{
                one.next = fTwo;
                zero.next = fOne;
            }
        }
        return res;
    }
}
