package BST;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

/*class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/

class PostOrder {

    static TreeNode buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            TreeNode currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new TreeNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(TreeNode root)
    {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            TreeNode root = buildTree(s);
            PostOrderSol g = new PostOrderSol();
            g.postOrder(root);
            System.out.print("\n");
            g.printPath(root, n);
            int lca = g.LCA(root,n,n2);
            System.out.print("\n");

            System.out.println("LCA = "+lca);
            System.out.print("\n");
            t--;
        }
    }
}
// } Driver Code Ends
//User function Template for Java



//User function Template for Java

/* A Binary Tree node
class TreeNode {
    int data;
    TreeNode left, right;
   TreeNode(int item)    {
        data = item;
        left = right = null;
    }
} */

class PostOrderSol
{

    public void postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return ;
        Stack<TreeNode> st = new Stack<>();
        while(true) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else
            {
                if (!st.empty() && st.peek().right != null) {
                    root = st.peek().right;
                } else {
                    if (st.empty()) break;
                    TreeNode temp = st.pop();
                    System.out.print(temp.data+" ");
                    while(!st.empty() && st.peek().right == temp) {
                        temp = st.peek();
                        System.out.print(st.pop().data + " ");

                    }
                }
            }
        }
    }


    public boolean printPath(TreeNode root, int n){
        //System.out.println("Inside printPath..  ");
        if(root ==  null) return false;
        if(root.data == n) return true;
        System.out.print(root.data+" ");
        if(printPath(root.left, n) || printPath(root.right, n)){
            return true;
        }
        return false;
    }

    public int LCA(TreeNode root, int n1, int n2){
        if(root == null) return -1;
        if(root.data == n1 || root.data == n2){
            return root.data;
        }
        int left = LCA(root.left,n1,n2);
        int right = LCA(root.right,n1,n2);

        if(left == -1 && right == -1)return -1;
        if(left != -1 && right != -1)return root.data;

        return left != -1 ? left : right;

    }

}
