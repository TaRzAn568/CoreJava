package BST;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConstructTreeFromPreOrder {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- >0){
            String s = br.readLine();
            TreeNode root = constructTree(s);

        }
    }
    public static TreeNode constructTree(String s){
        TreeNode root = null;
        TreeNode temp = null;
        for(String x : s.split(" ")){
            int data = Integer.parseInt(x);
            if(root == null){
                root = new TreeNode(data);
            }else{
                insertNode(root,data);
            }
        }
        System.out.println(root);
        printPreOrder(root);
        System.out.println();
        printPostOrder(root);
        return root;
    }
    public static void printPreOrder(TreeNode root){
        if(root == null)return;
        System.out.print(root.data+" ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printPostOrder(TreeNode root){
        if(root == null)return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void insertNode(TreeNode root, int x){
        if(root == null)return  ;
        if(x < root.data){
            if(root.left == null){
                root.left = new TreeNode(x);
            }else
            insertNode(root.left, x);
        }else{
            if(root.right == null){
                root.right = new TreeNode(x);
            }else
            insertNode(root.right, x);
        }

    }
}
