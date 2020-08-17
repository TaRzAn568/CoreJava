// { Driver Code Starts
import java.util.*;
import java.io.*;

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


class MergeAndSortLL
{
    singleLLNode head;

    void addToTheLast(singleLLNode node)
    {
        if(head == null)
            head = node;
        else
        {
            singleLLNode temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    void printList(singleLLNode node)
    {
        while(node!= null)
        {
            System.out.print(node.data+ " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String args[]) throws IOException
    {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0)
        {
            String nums[] = br.readLine().split(" ");
            int n1 = Integer.parseInt(nums[0]);
            int n2 = Integer.parseInt(nums[1]);
            MergeAndSortLL list = new MergeAndSortLL();
            nums = br.readLine().split(" ");
            int a1 = Integer.parseInt(nums[0]);
            singleLLNode head = new singleLLNode(a1);
            list.addToTheLast(head);
            for(int i=1;i<n1;i++)
            {
                int a = Integer.parseInt(nums[i]);
                list.addToTheLast(new singleLLNode(a));
            }
            //list.printList(list.head);

            MergeAndSortLL list2 = new MergeAndSortLL();
            nums = br.readLine().split(" ");
            int b1 = Integer.parseInt(nums[0]);
            singleLLNode head1 = new singleLLNode(b1);
            list2.addToTheLast(new singleLLNode(b1));
            for(int j=1;j<n2;j++)
            {
                int b = Integer.parseInt(nums[j]);
                list2.addToTheLast(new singleLLNode(b));
            }
            //list.printList(list2.head);

            MergeAndSortLLSol g = new MergeAndSortLLSol();
            singleLLNode result = g.mergeResult(list.head, list2.head);
            list.printList(result);
            t--;
        }
    }
}// } Driver Code Ends
/* Structure of the node*/
/* class singleLLNode
{
	int data;
	singleLLNode next;
	
	singleLLNode(int d)
	{
		data = d;
		next = null;
	}
} */

class MergeAndSortLLSol
{
    singleLLNode mergeResult(singleLLNode node1, singleLLNode node2)
    {

        return reverse(merge(node1, node2));
    }
    singleLLNode merge(singleLLNode l, singleLLNode r){
        if(l == null) return r;
        if(r == null) return l;
        singleLLNode res = null;
        if(l.data < r.data){
            res = l;
            res.next = merge(l.next,r);
        }else{
            res = r;
            res.next = merge(l,r.next);
        }
        return res;
    }

    singleLLNode res1 = null;
    singleLLNode reverse(singleLLNode head){
        if(head.next == null ){
            res1 = head;
            return res1;
        }

       reverse(head.next);
       head.next.next = head;
       head.next = null;


        return res1;
    }

}
