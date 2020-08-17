
import java.util.*;
import java.io.*;
import java.lang.*;

/*class singleLLNode
{
    int data;
    singleLLNode next;

    singleLLNode(int data)
    {
        this.data = data;
        this.next = null;
    }
}*/

class IntersectionOfTwoLL
{
    static singleLLNode append(singleLLNode head, int data)
    {
        if(head == null)
            return new singleLLNode(data);

        head.next = append(head.next, data);
        return head;

    }
    static void printList(singleLLNode node)
    {
        if(node == null)
            System.out.print("");
        else{
            while(node != null)
            {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }

    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();

        while(t-- > 0)
        {
            singleLLNode head1 = null;
            singleLLNode head2 = null;

            int temp = 0;
            int n1 = sc.nextInt();

            for(int i = 0; i < n1; i++)
            {
                temp = sc.nextInt();

                if(head1 == null)
                    head1 = new singleLLNode(temp);
                else head1 = append(head1, temp);
            }

            int n2 = sc.nextInt();
            for(int i = 0; i < n2; i++)
            {
                temp = sc.nextInt();

                if(head2 == null)
                    head2 = new singleLLNode(temp);
                else head2 = append(head2, temp);
            }

            singleLLNode result = new IntersectionOfTwoLLSol().findIntersection(head1, head2);

            printList(result);
            System.out.println();


        }
    }
}// } Driver Code Ends
//User function Template for Java

/*class singleLLNode
{
    int data;
    singleLLNode next;
    singleLLNode(int data)
    {
        this.data = data;
        this.next = null;
    }
}*/
class IntersectionOfTwoLLSol implements Comparator<singleLLNode>
{
    public  int compare(singleLLNode n1, singleLLNode n2){
        return n1.data > n2.data ? 1 :-1;
    }
    static singleLLNode findIntersection(singleLLNode head1, singleLLNode head2)
    {
        head1 = sortLL(head1);
        return head1;
    }

    public static singleLLNode sortLL(singleLLNode head){
        List<singleLLNode> l = new ArrayList<>();
        while(head != null)
        {
            l.add(head);
            head = head.next;
        }
        return head;
    }

}