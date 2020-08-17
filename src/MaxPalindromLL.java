
import java.util.*;
        import java.lang.Math;
/*class singleLLNode{
    int data;
    singleLLNode next;
    singleLLNode(int d){
        data=d;
        next=null;
    }
}*/
class MaxPalindromLL{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            singleLLNode head=null;
            head=insert(head,sc.nextInt());
            for(int i=1;i<n;i++)
                insert(head,sc.nextInt());
            MaxPalindromLLSol g=new MaxPalindromLLSol();
            System.out.println(g.maxPalindrome(head));
        }
    }
    public static singleLLNode insert(singleLLNode head,int val){
        if(head==null)
            return new singleLLNode(val);
        head.next=insert(head.next,val);
        return head;
    }
	/*public static void print(singleLLNode head){
		while(head!=null){
			System.out.println(head.data);
			head=head.next;
		}
	}*/
}// } Driver Code Ends
/*Complete the function below
singleLLNode is as follows:
class singleLLNode{
	int data;
	singleLLNode next;
	singleLLNode(int d){
		data=d;
		next=null;
	}
}*/
class MaxPalindromLLSol
{
    /*public static int maxPalindrome(singleLLNode head)
    {
        int maxlen = 1;
        if(head.next == null) return 1;
        else if(head.next != null && head.next.next == null){
            if(head.data == head.next.data){
                maxlen = 2;
                return 2;
            }
            else return 1;
        }

        singleLLNode temp = head;
        int n=0;
        while(temp != null){
            temp = temp.next;
            n++;
        }
        temp = head;
        boolean a[][] = new boolean[n][n];
        for(int i=0;i<n;i++){
            a[i][i] = true;
        }
        int c = 0;
        while(temp.next != null){
            if(temp.data == temp.next.data){
                a[c][c+1] = true;
                maxlen = 2;
            }
            c++;
            temp = temp.next;
        }
        temp = head;
        temp = head.next.next;
        singleLLNode temp2 = temp;
        int t1c = 2;
        while(temp != null){
            singleLLNode temp3 = head;
            temp2 = temp;
            int t3c = 0;
            int t2c = t1c;
            while(temp2 != null){
                if(temp2.data == temp3.data && a[t3c+1][t2c-1]){
                    a[t3c][t2c] = true;
                    if(maxlen < t2c-t3c+1){
                        maxlen = t2c-t3c+1;
                    }
                }
                temp3 = temp3.next;
                temp2 = temp2.next;
                t3c++;
                t2c++;
            }
            temp = temp.next;
            t1c++;
        }
        return maxlen;
    }*/


    static int countCommon(singleLLNode a, singleLLNode b)
    {
        int count = 0;

        // loop to count coomon in the list starting
        // from node a and b
        for (; a != null && b != null;
             a = a.next, b = b.next)

            // increment the count for same values
            if (a.data == b.data)
                ++count;
            else
                break;

        return count;
    }

    // Returns length of the longest palindrome
// sublist in given list
    static int maxPalindrome(singleLLNode head)
    {
        int result = 0;
        singleLLNode prev = null, curr = head;

        // loop till the end of the linked list
        while (curr != null)
        {
            // The sublist from head to current
            // reversed.
            singleLLNode next = curr.next;
            curr.next = prev;

            // check for odd length
            // palindrome by finding
            // longest common list elements
            // beginning from prev and
            // from next (We exclude curr)
            result = Math.max(result,
                    2 * countCommon(prev, next)+1);

            // check for even length palindrome
            // by finding longest common list elements
            // beginning from curr and from next
            result = Math.max(result,
                    2*countCommon(curr, next));

            // update prev and curr for next iteration
            prev = curr;
            curr = next;
        }
        return result;
    }

}