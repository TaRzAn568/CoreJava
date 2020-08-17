package BST;



import java.util.LinkedList;
        import java.util.Queue;
        import java.io.*;
        import java.util.*;

/*
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class LCAinBST {

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

    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());
        //Scanner sc = new Scanner(System.in);
        while(t > 0){
            String s = br.readLine();
            TreeNode root = buildTree(s);
            LCAinBSTSol g = new LCAinBSTSol();
            String X = br.readLine();
            String arr[] = X.split(" ");
            int x , y;
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[1]);
            System.out.println(g.LCA(root,x,y).data);
            t--;

        }
    }

}

// } Driver Code Ends
//User function Template for Java

/*
structure of TreeNode is as follows:
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/


class LCAinBSTSol
{
    TreeNode LCA(TreeNode node, int n1, int n2)
    {   if(node == null) return null;
        Stack<TreeNode> n1Ancestor = getAncestor(node, n1);
        Stack<TreeNode> n2Ancestor = getAncestor(node, n2);

        while(!n1Ancestor.empty()){
            TreeNode temp = n1Ancestor.peek();
            if(n2Ancestor.contains(n1Ancestor.pop())){
                return temp;
            }
        }
        System.out.println();



        /*for(TreeNode x : n1Ancestor){
            if(n2Ancestor.contains(x)){
                return x;
            }
        }*/
        return node;
    }

    static Stack<TreeNode> getAncestor(TreeNode node, int n){
        TreeNode temp = node;
        Stack<TreeNode> al = new Stack<>();
        while(n != temp.data)
        {
            al.push(temp);
            if(n < temp.data){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        if(n == temp.data)
            al.push(temp);
        return al;
    }

}
