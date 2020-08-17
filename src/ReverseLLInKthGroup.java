
import java.util.*;
        import java.lang.*;

class RLLNode
{
    int data;
    RLLNode next;
    RLLNode(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseLLInKthGroup
{
    static RLLNode head;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            RLLNode head = new RLLNode(a1);
            RLLNode tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new RLLNode(a));
                tail.next = new RLLNode(a);
                tail =tail.next;
            }

            int k = sc.nextInt();
            ReverseLLInKthGroupSolution gfg = new ReverseLLInKthGroupSolution();
            RLLNode res = gfg.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void addToTheLast(RLLNode node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            RLLNode temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    public static void printList(RLLNode node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

}

// } Driver Code Ends
/*node class of the linked list
class RLLNode
{
    int data;
    RLLNode next;
    RLLNode(int key)
    {
        data = key;
        next = null;
    }
}
*/
class ReverseLLInKthGroupSolution
{
    public static RLLNode reverse(RLLNode node, int k)
    {
        RLLNode priv = null;
        RLLNode curr = node, next = node, head1 = null, head2 = node;
        int c = 0;
        while(next != null){
            next = next.next;
            if(c==0 || c%k != 0){

                curr.next = priv;
            }else{
                curr.next = null;
                if(head1 != null)
                    head1.next = priv;
                if(c==k){
                    node = priv;
                }
                head1 = head2;
                head2 = curr;
            }
            priv = curr;
            curr = next;
            c++;

            if(next == null && head1 != null){
                head1.next = priv;
            }

        }
        if(c<=k && next == null){
            node = priv;
        }
        return node;
    }
}