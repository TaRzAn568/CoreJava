package BinaryTree;

import java.io.*;
import java.util.*;

class BTNode{
    int data;
    BTNode left;
    BTNode right;
    BTNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
/*https://practice.geeksforgeeks.org/problems/postorder-traversal/1#*/
public class Traversal {

    static BTNode buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        BTNode root = new BTNode(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<BTNode> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            BTNode currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new BTNode(Integer.parseInt(currVal));
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
                currNode.right = new BTNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(BTNode root)
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
            BTNode root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> res = g.postOrder(root);
            for (int i = 0; i < res.size (); i++)
                System.out.print (res.get (i) + " ");
            System.out.print("\n");
            t--;
        }
    }
}

class Tree
{
    static class Pair{
        BTNode node;
        int state;
        Pair(BTNode n, int s){
            this.node = n;
            this.state = s;
        }
    }
    static ArrayList<Integer> postOrder(BTNode root)
    {
        // Code here
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        while(!st.empty()){
            Pair peek = st.peek();
            int state = peek.state;
            BTNode node = peek.node;
            if(state == 1){
                preOrder.add(node.data);
                peek.state += 1;
                if(node.left != null){
                    st.push(new Pair(node.left,1));
                }
            }
            else if(state == 2){
                inOrder.add(node.data);
                peek.state += 1;
                if(node.right != null){
                    st.push(new Pair(node.right,1));
                }
            }
            else{
                postOrder.add(node.data);
                st.pop();
            }
        }
        return postOrder;
    }
}
