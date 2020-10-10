package BST;
import java.util.*;
import java.lang.*;
import java.io.*;


/*package whatever //do not write package name here */


class preToPostOrder {
        public static void main (String[] args)throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-- >0){
                int n = Integer.parseInt(br.readLine());
                String[] s = br.readLine().trim().split(" ");
                int [] a = new int[n];

                for(int i=0;i< n;i++)
                    a[i] = Integer.parseInt(s[i]);

                Node1 root = buildBST(a,a.length);
                printPostOrder(root);
                System.out.println();
            }
        }
    public static void printPostOrder(Node1 root){
        if(root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static Node1 buildBST(int[] a, int n){
        Node1 root = null;
        for(int i=0; i<n; i++){
            root = insertNode(root,a[i]);
        }
        return root;
    }
    public static Node1 insertNode(Node1 root,int x){
        if(root == null){
            root = new Node1(x);
            return root;
        }
        Node1 temp = root;
        while(temp != null){
            if(temp.data <= x){
                if(temp.right != null)
                temp = temp.right;
                else
                    break;
            }
            else{
                if(temp.left != null)
                    temp = temp.left;
                else break;
            }
        }
            if(temp.data <= x ){
                temp.right = new Node1(x);
            }
            else{
                temp.left = new Node1(x);
            }
        return root;
    }
}
class Node1{
    int data;
    Node1 left;
    Node1 right;
    public Node1(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
