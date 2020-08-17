package BST;


import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class OddLevelNodes{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node root=null;
            while(n-->0){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(root==null){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                            break;
                        case 'R':root.right=new Node(a1);
                            break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            OddLevelNodesSol g=new OddLevelNodesSol();
            g.nodeAtOdd(root);
            System.out.println();
        }
    }
    public static void insert(Node root,int a,int a1,char lr){
        if(root==null)
            return;
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                    break;
                case 'R':root.right=new Node(a1);
                    break;
            }
        }
        else{
            insert(root.left,a,a1,lr);
            insert(root.right,a,a1,lr);
        }
    }
}
// } Driver Code Ends


/*Complete the function below
Node is as follows
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/
 class C{
    static int c =1;
}

class OddLevelNodesSol{
    public void nodeAtOdd(Node root)
    {
        if(root == null) return;
        inOrder(root,1);
        C.c =1;

    }
    public void inOrder(Node root, int c){
        if(root == null){
            return;}
       // System.out.println("c = "+c);


        if((c%3) == 0){
            System.out.print(root.data+" ");
        }
        inOrder(root.left,c+1);

        inOrder(root.right,c+1);

    }
}