//https://practice.geeksforgeeks.org/problems/leaves-to-dll/1

import java.util.*;

class LeavesNodeToDllNode
{
    int data;
    LeavesNodeToDllNode left,right;
    LeavesNodeToDllNode(int d){
        data=d;
        left=right=null;
    }
}

public class LeavesNodeToDLL
{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
                continue;
            }
            LeavesNodeToDllNode root = null;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new LeavesNodeToDllNode(a);
                    switch(lr){
                        case 'L':root.left=new LeavesNodeToDllNode(a1);
                            break;
                        case 'R':root.right=new LeavesNodeToDllNode(a1);
                            break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            LeavesNodeToDllNode head = null;
            //inorder(root);
            LeavesToDLLSolution g=new LeavesToDLLSolution();
            root = g.convertToDLL(root);
            g.pritntDLL();
            System.out.println();

            // System.out.println(g.tilt(root));
        }
    }
    public static void insert(LeavesNodeToDllNode root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new LeavesNodeToDllNode(a1);
                    break;
                case 'R':root.right=new LeavesNodeToDllNode(a1);
                    break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    public static void inorder(LeavesNodeToDllNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}// } Driver Code Ends
/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

//User function Template for Java
/*
LeavesNodeToDllNode defined as
class LeavesNodeToDllNode{
    int data;
    LeavesNodeToDllNode left,right;
    LeavesNodeToDllNode(int d){
        data=d;
        left=right=null;
    }
}
*/
class LeavesToDLLSolution
{   LeavesNodeToDllNode head = null;
    LeavesNodeToDllNode convertToDLL(LeavesNodeToDllNode root)
    {
        List<Integer> al = new ArrayList<Integer>();
        getLeaves(root,al);
        System.out.println(al);
        //LeavesNodeToDllNode head = null;
        LeavesNodeToDllNode curr = null;
        for(int x: al){
            LeavesNodeToDllNode temp = new LeavesNodeToDllNode(x);
            if(curr == null){
                curr = temp;
                head = curr;
            }else {
                curr.right = temp;
                temp.left = curr;
                curr = curr.right;
            }
        }
        return head;
    }
    public void getLeaves(LeavesNodeToDllNode root, List<Integer> al){
        if(root==null )
            return;
        if(root.left == null && root.right == null){
            al.add(root.data);
            return ;
        }
        getLeaves(root.left,al);
        getLeaves(root.right,al);
    }
    public void pritntDLL(){
        pritntDLL(head);
    }
    void pritntDLL(LeavesNodeToDllNode head){
        if(head == null)
            return;
        while(head.right !=null){
            System.out.print(head.data+" ");
            head = head.right;
        }
        System.out.println(head.right.data+" ");
        while(head != null){
            System.out.print(head.data+" ");
            head = head.left;

        }

    }
}