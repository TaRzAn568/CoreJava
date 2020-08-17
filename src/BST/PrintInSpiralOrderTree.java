package BST;


//Contributed by Sudarshan Sharma
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


class PrintInSpiralOrderTree {

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
    void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Spiral g = new Spiral();
            g.printSpiral(root);
            System.out.println();

        }
    }
}



// } Driver Code Ends
//User function Template for Java


/*
// A Binary Tree node
class TreeNode
{
    int data;
    TreeNode left, right;

    TreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Spiral
{
    void printSpiral(TreeNode node)
    {
        //printLevelOrder(node);
        //Map<Integer,List<Integer>> m = printNthLevelNode(node);
        //System.out.println(m);
        int level = 2;
        //printNthNodes(node, level);
        int height = getHeight(node);
        for(int i=0;i<height; i++){
            if((i & 1) == 1)
            printNthNodesLtoRUsingRecurrsion(node, i);
            else
            printNthNodesRtoLUsingRecurrsion(node, i);
        }
    }

    void printLevelOrder(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp = node;
        q.add(temp);
        while(!q.isEmpty()){
            TreeNode f = q.poll();
            System.out.print(f.data+" ");
            if(f.left != null){
                q.add(f.left);
            }
            if(f.right != null){
                q.add(f.right);
            }
        }
    }
    Map<Integer,List<Integer>> printNthLevelNode(TreeNode node){
        Queue<TreeNode> q1 = new LinkedList<>();
        Map<Integer,List<Integer>> m = new HashMap<>();
        q1.add(node);
        List<Integer> ll = new LinkedList<>();
        ll.add(node.data);
        int i=0;
        m.put(i++,ll);
        while(!q1.isEmpty()){
            Queue<TreeNode> q2 = new LinkedList<>();
            while (!q1.isEmpty()){
                TreeNode temp = q1.poll();
                if(temp.left != null)
                    q2.add(temp.left);
                if(temp.right != null)
                    q2.add(temp.right);

            }
            q1.addAll(q2);
            ll = new LinkedList<>();
            while(!q2.isEmpty()){
                ll.add(q2.poll().data);
            }
            if(ll != null && ll.size() != 0)
                m.put(i++,ll);
        }
        return m;
    }
    void printNthNodes(TreeNode node, int level){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        q.add(null);
        int c = 0;
        if(level ==0)
        {
            System.out.print(node.data+" ");
            return;
        }
        while(!q.isEmpty()){

            TreeNode temp  = q.poll();
            if(temp == null) {
                c++;
                if(temp == null && c == level){
                    while(!q.isEmpty())
                        System.out.print(q.poll().data+" ");
                    break;
                }
                q.add(null);
            }else {
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }



        }
    }
    static int getHeight(TreeNode node){
        if(node == null)
            return 0;
        int lH = getHeight(node.left) + 1;
        int rH = getHeight(node.right) + 1;

        return Math.max(lH,rH);
    }

    public static void printNthNodesLtoRUsingRecurrsion(TreeNode node, int level){
       if(node == null) return;
        if(level == 0){
            System.out.print(node.data+" ");
            return;
        }
        printNthNodesLtoRUsingRecurrsion(node.left, level-1);
        printNthNodesLtoRUsingRecurrsion(node.right, level-1);
    }

    public static void printNthNodesRtoLUsingRecurrsion(TreeNode node, int level){
       if(node == null) return;
        if(level == 0){
            System.out.print(node.data+" ");
            return;
        }
        printNthNodesRtoLUsingRecurrsion(node.right, level-1);
        printNthNodesRtoLUsingRecurrsion(node.left, level-1);
    }
}