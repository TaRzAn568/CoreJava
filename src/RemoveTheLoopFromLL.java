// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

/*class SingleLLNode
{
    int data;
    SingleLLNode next;

}*/


class RemoveTheLoopFromLLUtil
{
    public static SingleLLNode newNode(int data)
    {
        SingleLLNode temp = new SingleLLNode(data);

        return temp;
    }

    public static SingleLLNode insert(SingleLLNode head, int data)
    {
        if (head == null)
            head = newNode(data);
        else
            head.next = insert(head.next, data);
        return head;

    }

    public static void makeLoop(SingleLLNode head, int x)
    {
        if (x == 0)
            return;
        SingleLLNode curr = head;
        SingleLLNode last = head;

        int counter = 0;
        while (counter < x)
        {
            curr = curr.next;
            counter++;
        }

        while (last.next != null)
            last = last.next;
        last.next = curr;
    }

    public static int detectloop(SingleLLNode head)
    {
        SingleLLNode hare = head.next;
        SingleLLNode tortoise = head;
        while (hare != tortoise && hare != null && tortoise != null)
        {
            hare = hare.next;
            tortoise = tortoise.next;
            if (hare != null && hare.next != null)
                hare = hare.next;

            if (hare == tortoise)
                return 1;
        }

        if (hare == tortoise)
            return 1;
        return 0;
    }


    public static int length(SingleLLNode head, boolean hasloop)
    {
        int len = 0;
        if (hasloop == false)
        {
            SingleLLNode temp = head;
            while (temp != null)
            {
                len++;
                temp = temp.next;
            }

            return len;
        }

        else
        {
            SingleLLNode hare = head.next;
            SingleLLNode tortoise = head;
            while (hare != tortoise)
            {
                hare = hare.next;
                tortoise = tortoise.next;
                hare = hare.next;

                if (hare == tortoise)
                    break;
            }


            int looplen = 0;
            while (hare.next!=tortoise)
            {
                hare = hare.next;
                looplen++;

            }

            looplen++;

            SingleLLNode begin = head;
            int startlen = 0;
            tortoise = tortoise.next;
            while (begin != tortoise)
            {

                begin = begin.next;
                tortoise = tortoise.next;
                startlen++;

            }

            return looplen + startlen;

        }
    }

}

class RemoveTheLoopFromLL
{
    public static void main (String[] args) {
        /* code */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t--> 0)
        {
            int sizeOfArray = sc.nextInt();
            int arr[] = new int[sizeOfArray];

            for(int i = 0; i < sizeOfArray; i++)
                arr[i] = sc.nextInt();

            SingleLLNode head = null;

            for (int i = 0; i < sizeOfArray; i++)
            {
                head = new RemoveTheLoopFromLLUtil().insert(head, arr[i]);
            }
            int x = sc.nextInt();
            new RemoveTheLoopFromLLUtil().makeLoop(head, x);

            int length = 0;
            if (new RemoveTheLoopFromLLUtil().detectloop(head) == 1)
            {
                length=new RemoveTheLoopFromLLUtil().length(head, true);
            }
            else
            {
                length = new RemoveTheLoopFromLLUtil().length(head, false);
            }
            new RemoveTheLoopFromLLSolution().removeTheLoop(head);

            if (new RemoveTheLoopFromLLUtil().detectloop(head) == 0 && length == new RemoveTheLoopFromLLUtil().length(head, false))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}


// } Driver Code Ends
/*Complete The function
SingleLLNode is as follows:
class SingleLLNode {
    int data;
    SingleLLNode next;
    SingleLLNode(int d) {
        data = d;
        next = null;
    }
}*/

class RemoveTheLoopFromLLSolution{

    // This function will remove the loop from the linked list, space complexity = O(n)
    /*public static void removeTheLoop(SingleLLNode head)
    {   if(head == null)
        return;
        Set<SingleLLNode> set = new HashSet<SingleLLNode>();
        set.add(head);
        while(head != null){

            if(set.contains(head.next)){
                head.next = null;
                break;
            }
            set.add(head.next);
            head = head.next;
        }
    }*/
//  space complexity = O(1)
    public static void removeTheLoop(SingleLLNode head)
    {
        if(head == null)
            return;
        SingleLLNode slow = head;
        SingleLLNode fast = head;
        boolean res = false;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                res = true;
                break;
            }
        }
        if(!res)
            return ;
        slow = head;
        while(fast.next!=slow.next)
        {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = null;
    }

}
