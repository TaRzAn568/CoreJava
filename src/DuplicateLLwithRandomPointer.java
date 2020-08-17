

// { Driver Code Starts
import java.util.*;

class RNode {
    int data;
    RNode next, arb;

    RNode(int d) {
        data = d;
        next = arb = null;
    }
}

class DuplicateLLwithRandomPointer {
    static RNode head;

    public static void addToTheLast(RNode node) {
        if (head == null) {
            head = node;
        } else {
            RNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }

    public static boolean validation(RNode head, RNode res, RNode cloned_add,
                                     RNode generated_add) {

        if (generated_add == cloned_add) return false;

        RNode temp1 = head;
        RNode temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        /*if lengths not equal */

        if (len1 != len2) return false;

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1.data != temp2.data) return false;
            if (temp1.arb != null && temp2.arb != null) {
                if (temp1.arb.data != temp2.arb.data) return false;
            } else if (temp1.arb != null && temp2.arb == null)
                return false;
            else if(temp1.arb== null && temp2.arb !=null)
                return false;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    //   public static void printList()

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            RNode generated_add = null;
            int n = sc.nextInt();
            int q = sc.nextInt();

            int a1 = sc.nextInt();
            RNode head = new RNode(a1);
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new RNode(a));
            }

            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                RNode tempA = head;
                int count = -1;

                while (tempA != null) {
                    count++;
                    if (count == a - 1) break;
                    tempA = tempA.next;
                }
                RNode tempB = head;
                count = -1;

                while (tempB != null) {
                    count++;
                    if (count == b - 1) break;
                    tempB = tempB.next;
                }

                // when both a is greater than N
                if (a <= n) tempA.arb = tempB;
            }

            generated_add = head;
            Clone g = new Clone();
            RNode res = g.copyList(head);

            RNode cloned_add = res;

            if (validation(head, res, cloned_add, generated_add) == true)
                System.out.println("1");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends
/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*
class RNode {
    int data;
    RNode next, arb;

    RNode(int d) 
    { 
        data = d;
        next = arb = null; 
        
    }
}*/
// function to copy linked list
class Clone {
    RNode copyList(RNode head) {
        RNode temp = head;
        RNode temp2 = head.next;
        while(temp != null){
            temp.next = new RNode(temp.data);
            temp.next.next = temp2;
            temp = temp2;
            if(temp2 != null)
            temp2 = temp2.next;
        }
        temp = temp2 = head;
        while(temp.next != null && temp.arb != null){
            temp.next.arb = temp.arb.next;
            temp = temp.next.next;

        }
        temp = head;
        temp2 = head.next;
        RNode temp3 = head.next;
        while(temp2.next != null){
            temp.next = temp.next.next;
            temp = temp.next;
            temp2.next = temp2.next.next;
            temp2 = temp2.next;
        }
        temp.next = null;
        return temp3;
    }
}
