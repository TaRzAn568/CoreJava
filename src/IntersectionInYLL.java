// { Driver Code Starts


import java.util.*;


class YNode
{
    int data;
    YNode next;
    YNode(int d) {
        data = d;
        next = null;
    }
}

class IntersectionInYLL
{
    YNode head = null;
    YNode tail = null;

    public void addToTheLast(YNode node)
    {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            //YNode temp = head;
            //while (temp.next != null)
            //temp = temp.next;

            //temp.next = node;
            tail.next=node;
            tail = node;
        }
    }

    /* Function to print linked list */
    void printList()
    {
        YNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }



    /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while(t>0)
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            IntersectionInYLL llist1 = new IntersectionInYLL();
            IntersectionInYLL llist2 = new IntersectionInYLL();
            IntersectionInYLL llist3 = new IntersectionInYLL();

            int a1=sc.nextInt();
            YNode head1= new YNode(a1);
            YNode tail1= head1;

            for (int i = 1; i < n1; i++)
            {
                int a = sc.nextInt();
                tail1.next = (new YNode(a));
                tail1= tail1.next;
            }


            int b1=sc.nextInt();
            YNode head2 = new YNode(b1);
            YNode tail2 = head2;
            for (int i = 1; i < n2; i++)
            {
                int b = sc.nextInt();
                tail2.next = (new YNode(b));
                tail2= tail2.next;
            }

            int c1=sc.nextInt();
            YNode head3= new YNode(c1);
            tail1.next = head3;
            tail2.next = head3;
            YNode tail3=head3;
            for (int i = 1; i < n3; i++)
            {
                int c = sc.nextInt();
                tail3.next = (new YNode(c));
                tail3= tail3.next;
            }

            Intersect obj = new Intersect();
            System.out.println(obj.intersectPoint(head1, head2));
            t--;
        }
    }
}
// } Driver Code Ends
/* YNode of a linked list
 class YNode {
   int data;
    YNode next;
    YNode(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    YNode head;  // head of list
}
This is method only submission.  You only need to complete the method. */
class Intersect
{
    int intersectPoint(YNode headA, YNode headB)
    {
        int res = -1;
        Stack<YNode> stackA = new Stack<>();
        Stack<YNode> stackB = new Stack<>();
        while(headA != null){
            stackA.push(headA);
            headA = headA.next;
        }
        while(headB != null){
            stackB.push(headB);
            headB = headB.next;
        }
        if(stackA.peek() != stackB.peek()){
            return res;
        }
        while(stackA.peek() == stackB.peek()){
            res = stackA.peek().data;
            stackA.pop();
            stackB.pop();
        }
        return res;

    }
}
