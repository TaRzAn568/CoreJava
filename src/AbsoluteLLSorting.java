//https://practice.geeksforgeeks.org/problems/absolute-list-sorting/1
import java.util.*;

public class AbsoluteLLSorting
{
    SingleLLNode head;

    /* Function to print linked list */
    void printList(SingleLLNode head)
    {
        SingleLLNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }


    /* Inserts a new SingleLLNode at front of the list. */
    public void addToTheLast(SingleLLNode node)
    {

        if (head == null)
        {
            head = node;
        } else
        {
            SingleLLNode temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
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
            AbsoluteLLSorting llist = new AbsoluteLLSorting();
            //int n=Integer.parseInt(br.readLine());
            int a1=sc.nextInt();
            SingleLLNode head= new SingleLLNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new SingleLLNode(a));
            }

            AbsoluteLLSortingSolution gfgobj = new AbsoluteLLSortingSolution();
            llist.head = gfgobj.sortedList(llist.head);
            llist.printList(llist.head);

            t--;
        }
    }
}

// } Driver Code Ends
/* The structure of the node of the Linked List is
class SingleLLNode
{
   int data;
   SingleLLNode next;
   SingleLLNode(int d) {data = d; next = null; }
 }
*/

class AbsoluteLLSortingSolution
{
    SingleLLNode sortedList(SingleLLNode head)
    {
        if(head == null || head.next == null)
            return head;
        SingleLLNode curr = head;
        SingleLLNode nextNode = head.next;
        while(nextNode !=null){
            if(nextNode.data < 0){
                SingleLLNode temp = nextNode.next;
                nextNode.next = head;
                head = nextNode;
                curr.next = temp;
                nextNode = temp;
            }else{
                nextNode = nextNode.next;
                curr = curr.next;
            }
        }
        return head;
    }


}
