
import java.util.Scanner;
        import java.util.*;
        import java.io.*;

class FLNode
{
    int data;
    FLNode next;
    FLNode bottom;

    FLNode(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}


class flatternLL
{
    FLNode head;

    void printList(FLNode node)
    {
        //FLNode temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
    public  static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        flatternLL list = new flatternLL();
        while(t>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0;i<N;i++)
                arr[i] = sc.nextInt();

            FLNode temp = null;
            FLNode tempB = null;
            FLNode pre = null;
            FLNode preB = null;
            int flag=1;
            int flag1=1;
            for(int i=0; i<N;i++)
            {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new FLNode(a1);
                if(flag == 1)
                {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                }
                else
                {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for(int j=0;j<m;j++)
                {
                    int a = sc.nextInt();
                    tempB = new FLNode(a);
                    if(flag1 == 1)
                    {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    }
                    else
                    {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            //list.printList();
            flatternLLSol g = new flatternLLSol();
            FLNode root = g.flatten(list.head);
            list.printList(root);

            t--;
        }
    }
}// } Driver Code Ends
/*FLNode class  used in the program
class FLNode
{
	int data;
	FLNode next;
	FLNode bottom;
	
	FLNode(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class flatternLLSol
{
    FLNode flatten(FLNode root)
    {
        if(root == null)
            return null;
        FLNode temp1 = root;
        FLNode bottom1 = root.bottom;
        FLNode temp2 = root.next;

        while(temp2 != null){
            while(bottom1 != null && bottom1.data < temp2.data){
                temp1 = bottom1;
                bottom1 = bottom1.bottom;
            }


            if(temp2.bottom != null){
                root.next = temp2.bottom;
                temp2.bottom.next = temp2.next;
            }
            else{
                root.next = temp2.next;
            }

            temp2.next = null;
            temp2.bottom = null;
            temp1.bottom = temp2;
            temp1 = temp1.bottom;
            temp1.bottom = bottom1;

            temp1 = root;
            bottom1 = temp1.bottom;
            temp2 = root.next;
        }
        return root;
    }
}