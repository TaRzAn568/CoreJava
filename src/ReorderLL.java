// { Driver Code Starts
import java.util.*;

/*class SingleLLNode
{
    int data;
    SingleLLNode next;
    SingleLLNode(int d) {
        data = d;
        next = null;
    }
}*/

public class ReorderLL
{
    SingleLLNode head;  // head of lisl
  
    /* Linked list SingleLLNode*/
   
                    
    /* Utility functions */

    /* Inserts a new SingleLLNode at front of the list. */
    public void addToTheLast(SingleLLNode node) {

        if (head == null) {
            head = node;
        } else {
            SingleLLNode temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }
    /* Function to print linked list */
    void printList()
    {
        SingleLLNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            ReorderLL llist = new ReorderLL();

            int a1=sc.nextInt();
            SingleLLNode head= new SingleLLNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new SingleLLNode(a));
            }

            llist.head = new ReorderLLSolution().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}// } Driver Code Ends
/* Following is the Linked list node structure */

/*class SingleLLNode
{
    int data;
    SingleLLNode next;
    SingleLLNode(int d) {
        data = d; 
        next = null;
    }
}*/

class ReorderLLSolution
{
    /*SingleLLNode reorderlist(SingleLLNode head)
    {
        // Your code here
        if(head == null || head.next == null || head.next.next == null)
            return head;
        SingleLLNode curr = head;
        while(curr != null){
            SingleLLNode secondLast = getSecondLast(curr);
            if(secondLast == null){
                break;
            }else{
                SingleLLNode nextNode = curr.next;
                SingleLLNode last = secondLast.next;
                curr.next = last;
                last.next = nextNode;
                curr = nextNode;
                secondLast.next = null;
            }
        }
        return head;
    }*/

    //using reccursion
    SingleLLNode reorderlist(SingleLLNode head)
    {
        func(head,head);
        return head;
    }
    SingleLLNode func(SingleLLNode head, SingleLLNode tail){
        if(tail==null){
            return head;
        }
        head=func(head,tail.next);
        System.out.println("head = "+head.data);
        if(head.next==null){

            return head;
        }
        if(head!=tail && head.next!=tail){
            SingleLLNode temp=head.next;
            head.next=tail;
            tail.next=temp;
            head=temp;
        }else{
            if(head!=tail){
                head=head.next;
            }
            head.next=null;
        }
        System.out.println("head last = "+head.data);
        return head;
    }

    SingleLLNode getSecondLast(SingleLLNode root){
        if(root.next == null || root.next.next == null)
            return null;
        while(root.next.next != null){
            root = root.next;
        }
        return root;
    }
}
