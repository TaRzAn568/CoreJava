


// { Driver Code Starts
import java.util.*;

/*
class singleLLNode
{

    int data;
    singleLLNode next;

    singleLLNode(int d)
    {
        data = d;
        next = null;
    }
}
*/


public class removeGraterinLL
{
    singleLLNode head;

    /* Linked list singleLLNode*/
    /* Utility functions */
    /* Inserts a new singleLLNode at front of the list. */
    public void addToTheLast(singleLLNode node)
    {

        if (head == null)
        {
            head = node;
        }
        else
        {
            singleLLNode temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = node;
        }
    }

    /* Function to print linked list */
    void printList()
    {
        singleLLNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            removeGraterinLL llist = new removeGraterinLL();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            singleLLNode head = new singleLLNode(a1);
            llist.addToTheLast(head);

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new singleLLNode(a));
            }


            new removeGraterinLLSol().compute(llist);
            llist.printList();
            t--;
        }
    }
}// } Driver Code Ends
/*
class singleLLNode {
   int data;
   singleLLNode next;

  singleLLNode(int data) {
      this.data = data;
  }
}

public class removeGraterinLL
{
    singleLLNode head;
    // Member Methods
}*/

/* This is method only submission.
You only need to complete the below method.*/
class removeGraterinLLSol
{
    void compute(removeGraterinLL l)
    {
        singleLLNode head = l.head;
        if(head == null || head.next == null) return;
        l.printList();

        l.head = reverse(head);
        l.printList();
        singleLLNode temp = l.head;

        while(temp != null && temp.next != null){
            if(temp.data > temp.next.data){
                temp.next = temp.next.next;
            }else if(temp.data < temp.next.data){
                temp = temp.next;
            }
        }
        l.head = reverse(l.head);
    }

    public static singleLLNode reverse(singleLLNode head){
        if(head == null || head.next == null) return head;
        singleLLNode prev = null;
        singleLLNode curr = head;
        singleLLNode next = head.next;

        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
}
  