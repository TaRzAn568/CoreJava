// { Driver Code Starts
import java.io.*;
import java.util.Scanner;
class Node4
{
    int data;
    Node4 right,down;

    Node4(int data){
        this.data = data;
        right = null;
        down = null;
    }
}
public class LinkedListMatrix {

    // Node4 of linked list

    static void display(Node4 head) {

        Node4 Rp;
        Node4 Dp = head;
        while (Dp != null) {
            Rp = Dp;
            while (Rp != null) {
                System.out.print(Rp.data + " ");
                Rp = Rp.right;
            }
            Dp = Dp.down;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int [][]arr=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++){
                    int p=sc.nextInt();arr[i][j]=p;}
            }
            ConvertMetrixToLL obj=new ConvertMetrixToLL();
            Node4 head = obj.construct(arr, n);
            display(head);
        }
    }

}// } Driver Code Ends
/*class Node4

class Node4
{
    int data;
    Node4 right,down;
    
    Node4(int data){
        this.data = data;
        right = null;
        down = null;
    }
}
*/
/*Function should return the head of the 2D LL.*/
class ConvertMetrixToLL
{
    static Node4 construct(int arr[][],int n)
    {
        return buildLL(arr,n,0,0);
    }
    public static Node4 buildLL(int[][] arr,int n, int i, int j){
        if(i> n-1 || j> n-1)
            return null;
        Node4 temp = new Node4(arr[i][j]);
        temp.down = buildLL(arr,n,i+1,j);
        temp.right = buildLL(arr,n,i,j+1);
        return temp;
    }
    
}