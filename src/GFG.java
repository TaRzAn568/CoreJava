// { Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = null;
            while (n-- > 0) {
                int a1 = sc.nextInt();
                int a2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                if (root == null) {
                    root = new Node(a1);
                    switch (lr) {
                        case 'L':
                            root.left = new Node(a2);
                            break;
                        case 'R':
                            root.right = new Node(a2);
                            break;
                    }
                } else {
                    insert(root, a1, a2, lr);
                }
            }
            DiagonalSum g = new DiagonalSum();
            g.diagonalsum(root);
            System.out.println();
        }
    }
    public static void insert(Node root, int a1, int a2, char lr) {
        if (root == null) return;
        if (root.data == a1) {
            switch (lr) {
                case 'L':
                    root.left = new Node(a2);
                    break;
                case 'R':
                    root.right = new Node(a2);
                    break;
            }
        } else {
            insert(root.left, a1, a2, lr);
            insert(root.right, a1, a2, lr);
        }
    }
}// } Driver Code Ends
/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class DiagonalSum {
   /* public void diagonalsum(Node root) {
        if(root == null){
            return;
        }
        Node temp2 = root;
        int lsum = root.data;
        while(temp2 != null){
            int privLsum = lsum;
            lsum = 0;
            Node temp1 = temp2;
            int rsum = temp1.data;
            while(temp1 != null){
                if(temp1.right != null)
                    rsum += temp1.right.data;
                if(temp1.left != null)
                    lsum += temp1.left.data;
                temp1 = temp1.right;
            }
            System.out.print(rsum + privLsum - temp2.data+" ");
            temp2 = temp2.left;
        }
    }*/

    HashMap<Integer,Integer> hp;
    void p(Node root,int h,int left)
    {
        if(root==null)
            return;
        if(left==1)
        {
            int sum=0;
            Node t = root;
            while(t!=null)
            {
                sum+=t.data;
                t=t.right;
            }
            if(hp.containsKey(h)==false)
            {
                hp.put(h,0);
            }
            hp.put(h,hp.get(h)+sum);
        }
        p(root.left,h+1,1);
        p(root.right,h,0);
    }
    public void diagonalsum(Node root)
    {
        hp = new HashMap<Integer,Integer>();

        p(root,0,1);
        //System.out.println(hp.toString());
        for(int i:hp.values())
            System.out.print(i+" ");


    }
}