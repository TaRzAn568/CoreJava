package BinaryTree;
import java.util.*;
import java.io.*;

 class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }

}

class TreeUtil{
    TreeNode root;
    Queue<TreeNode> que;

    TreeUtil(){
        this.que = new LinkedList<>();
    }


    TreeNode buildTree(List<Integer> levelOrder){

        for(int x : levelOrder){
            addNode(x);
        }
        return root;
    }


    void addNode(int x){
        TreeNode newNode = new TreeNode(x);
        if(root == null){
            root = newNode;
            que.add(newNode);
            return;
        }
        TreeNode peek = que.peek();
        if(peek.left == null){
            peek.left = newNode;
        }
        else if(peek.right == null){
            peek.right = newNode;
            que.poll();
        }
        que.add(newNode);

    }

    void inOrder(TreeNode node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }

}

interface TreeIterator{
     boolean hasNext();
     TreeNode next();
}
class Pair{
     TreeNode node;
     int state;
     Pair(TreeNode node, int state){
         this.node = node;
         this.state = state;
     }
}

class InOrderTreeIteratorImpl implements TreeIterator{
     TreeNode root;
     Stack<Pair> stack;

    InOrderTreeIteratorImpl(TreeNode root){
        this.root = root;
        this.stack = new Stack<>();
        this.stack.push(new Pair(root,1));
    }

   public boolean hasNext(){

        if(stack.empty() )
            return false;
        return true;
    }
    public TreeNode next(){

        TreeNode retVal = null;
        while (!stack.empty()) {
            Pair peek = stack.empty() ? null : stack.peek();
            if (peek.state == 1) {
                if (peek.node.left != null) {
                    peek.state++;
                    stack.push(new Pair(peek.node.left, 1));
                }
                 else
                     peek.state++;

            }
            else if(peek.state == 2){
                retVal = peek.node;
                if(peek.node.right != null){
                    stack.pop();
                    //peek.state++;
                    stack.push(new Pair(peek.node.right,1));
                }
                else {
                 //   peek.state++;
                    stack.pop();
                }
                break;
            }
            else{
                stack.pop();
            }
        }
        return retVal;
    }

}

class PostOrderTreeIteratorImpl implements TreeIterator{
    TreeNode root;
    Stack<Pair> stack;

    PostOrderTreeIteratorImpl(TreeNode root){
        this.root = root;
        this.stack = new Stack<>();
        this.stack.push(new Pair(root,1));
    }

    public boolean hasNext(){

        if(stack.empty())
            return false;
        return true;
    }
    public TreeNode next(){

        TreeNode retVal = null;
        while (!stack.empty()) {
            Pair peek = stack.empty() ? null : stack.peek();
            if (peek.state == 1) {
                if (peek.node.left != null) {
                    peek.state++;
                    stack.push(new Pair(peek.node.left, 1));
                }
                else
                    peek.state++;

            }
            else if(peek.state == 2){
                if(peek.node.right != null){
                    //stack.pop();
                    peek.state++;
                    stack.push(new Pair(peek.node.right,1));
                }
                else {
                       peek.state++;
                    //stack.pop();
                }
            }
            else{
                retVal = peek.node;
                stack.pop();
                break;
            }
        }
        return retVal;
    }

}

class PreOrderTreeIteratorImpl implements TreeIterator{
    TreeNode root;
    Stack<Pair> stack;

    PreOrderTreeIteratorImpl(TreeNode root){
        this.root = root;
        this.stack = new Stack<>();
        this.stack.push(new Pair(root,1));
    }

    public boolean hasNext(){

        if(stack.empty())
            return false;
        return true;
    }
    public TreeNode next(){

        TreeNode retVal = null;
        while (!stack.empty()) {
            Pair peek = stack.empty() ? null : stack.peek();
            if (peek.state == 1) {
                retVal = peek.node;
                if (peek.node.left != null) {
                    peek.state++;
                    stack.push(new Pair(peek.node.left, 1));
                }
                else
                    peek.state++;
                break;
            }
            else if(peek.state == 2){
                if(peek.node.right != null){
                    stack.pop();
                    //peek.state++;
                    stack.push(new Pair(peek.node.right,1));
                }
                else {
                   // peek.state++;
                    stack.pop();
                }

            }
            else{
                stack.pop();
            }
        }
        return retVal;
    }

}

 class TreeIteratorDriver {
    public static void main(String[]  akb)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Integer> levelorder = new ArrayList<>();
        for(String x : input.split(" "))
            levelorder.add(Integer.parseInt(x));

        TreeUtil treeUtil = new TreeUtil();
        TreeNode root = treeUtil.buildTree(levelorder);
        treeUtil.inOrder(root);
        System.out.println();
        TreeIterator ti = new InOrderTreeIteratorImpl(root);
        while(ti.hasNext())
        {
            System.out.print(ti.next().val+" ");
        }
        System.out.println();

        ti = new PostOrderTreeIteratorImpl(root);
        while(ti.hasNext())
        {
            System.out.print(ti.next().val+" ");
        }

        System.out.println();

        ti = new PreOrderTreeIteratorImpl(root);
        while(ti.hasNext())
        {
            System.out.print(ti.next().val+" ");
        }
    }

}



