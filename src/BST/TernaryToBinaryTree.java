package BST;

import java.util.*;
import java.lang.*;

/*class TreeNode
{
    char data;
    TreeNode left, right;
    TreeNode(char key)
    {
        data = key;
        left = right = null;
    }
}*/

class TernaryToBinaryTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            String str = "";
            str = sc.next();
            TernaryToBinaryTreeSol gfg = new TernaryToBinaryTreeSol();
            TreeNode res = gfg.convertExp(str, 0);
            printInorder(res);
            System.out.println();
        }
    }

    public static void printInorder(TreeNode node)
    {
        if(node == null)
            return;

        System.out.print(node.data + " ");
        printInorder(node.left);
        printInorder(node.right);

    }
}
// } Driver Code Ends


/*node of the binary tree
class TreeNode
{
    char data;
    TreeNode left, right;
    TreeNode(char key)
    {
        data = key;
        left = right = null;
    }
}*/
class TernaryToBinaryTreeSol
{

    public static TreeNode convertExp(String str, int i)
    {
        
        /*if(i > str.length())
         return null;
         
       TreeNode root = new TreeNode(str.charAt(i));
        i++;
        if(i < str.length() && str.charAt(i) == '?')
         root.left = convertExp(str, i+1);
        if(i < str.length() && str.charAt(i) == ':')
         root.right = convertExp(str, i+1);
      
      return root;  */

        TreeNode root = null;
       root =  fun(str,root);
        return root;
    }

    public static TreeNode fun(String s, TreeNode root){
        if(s.length() == 0) return null;
        TreeNode temp = new TreeNode((char)s.substring(0,1).charAt(0));
        if(root == null){
            root = temp;
        }
        int n = s.length();
        if(n>2){
            temp.right = new TreeNode((char)s.substring(n-1,n).charAt(0));
            temp.left = fun(s.substring(2,s.length()-2),root);
        }else{
            return temp;
        }
        return temp;
    }

}