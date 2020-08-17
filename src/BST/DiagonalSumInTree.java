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

class DiagonalSumInTree {

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

        while(t > 0)
        {
            String s = br.readLine();
            TreeNode root = buildTree(s);
            DiagonalSumInTreeSol g = new DiagonalSumInTreeSol();
            g.diagonalSum(root);
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends


/*Complete the function below
TreeNode is as follows:
class TreeNode{
    int data;
    TreeNode left,right;
    TreeNode(int d){
        data=d;
        left=right=null;
    }
}
*/
class DiagonalSumInTreeSol {
    public void diagonalSum(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        int sum = 0;
        while(!q1.isEmpty()){
            TreeNode temp = q1.poll();
            while(temp != null){
                if(temp.left != null)
                    q2.add(temp.left);
                sum += temp.data;
                temp = temp.right;
            }
            if(q1.isEmpty()){
                System.out.println(sum+" ");
                sum = 0;
                q1.addAll(q2);
                q2.removeAll(q2);

            }

        }
    }
}