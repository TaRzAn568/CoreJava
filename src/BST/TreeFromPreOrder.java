package BST;

// Java program to construct a binary tree from preorder traversal 

// A Binary Tree node 
/*class TreeNode
{
    int data;
    TreeNode left, right;

    TreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Index
{
    int index = 0;
}

public class TreeFromPreOrder
{
    TreeNode root;
    Index myindex = new Index();

    /* A recursive function to create a Binary Tree from given pre[] 
       preLN[] arrays. The function returns root of tree. index_ptr is used 
       to update index values in recursive calls. index must be initially 
       passed as 0 */
    TreeNode constructTreeUtil(int pre[], char preLN[], Index index_ptr,
                           int n, TreeNode temp)
    {
        // store the current value of index in pre[] 
        int index = index_ptr.index;

        // Base Case: All nodes are constructed 
        if (index == n)
            return null;

        // Allocate memory for this node and increment index for 
        // subsequent recursive calls 
        temp = new TreeNode(pre[index]);
        (index_ptr.index)++;

        // If this is an internal node, construct left and right subtrees  
        // and link the subtrees 
        if (preLN[index] == 'N')
        {
            temp.left = constructTreeUtil(pre, preLN, index_ptr, n,
                    temp.left);
            temp.right = constructTreeUtil(pre, preLN, index_ptr, n,
                    temp.right);
        }

        return temp;
    }

    // A wrapper over constructTreeUtil() 
    TreeNode constructTree(int pre[], char preLN[], int n, TreeNode node)
    {
        // Initialize index as 0. Value of index is used in recursion to 
        // maintain the current index in pre[] and preLN[] arrays. 
        int index = 0;

        return constructTreeUtil(pre, preLN, myindex, n, node);
    }

    /* This function is used only for testing */
    void printInorder(TreeNode node)
    {
        if (node == null)
            return; 
   
        /* first recur on left child */
        printInorder(node.left); 
   
        /* then print the data of node */
        System.out.print(node.data + " "); 
   
        /* now recur on right child */
        printInorder(node.right);
    }

    // driver function to test the above functions 
    public static void main(String args[])
    {
        TreeFromPreOrder tree = new TreeFromPreOrder();
        int pre[] = new int[]{/*10, 30, 20, 5, 15*/                 0,   1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11,12, 13, 14};
        char preLN[] = new char[]{/*'N', 'N', 'L', 'L', 'L'*/       'N','N','N','L','L','N','L','L','N','N','L','L','N','L','L' };
        int n = pre.length;

        // construct the above tree 
        TreeNode mynode = tree.constructTree(pre, preLN, n, tree.root);

        // Test the constructed tree 
        System.out.println("Following is Inorder Traversal of the"
                + "Constructed Binary Tree: ");
        tree.printInorder(mynode);
    }
}
