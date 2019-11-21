import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Node{
    String data;
    Node right;
    Node left;

    Node(String item){
        data = item;
    }
}

public class TreeFromPreOrderAndInOrder {
    public static void  main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        //int t = Integer.parseInt(br.readLine());
        //String [] inOrder = br.readLine().split(" ");
        //String [] preOrder = br.readLine().split(" ");

        String [] inOrder = new String[] {  "D","B","E","A", "F", "C" };
        String [] preOrder = new String[] { "A", "B", "D", "E", "C", "F" }; ;
        Node tNode = buildTree(inOrder, preOrder,0,inOrder.length-1);
    }
    Node root;
    static int preIndex = 0;

    public static Node buildTree(String[] inOrder, String[] preOrder, int start, int end){

        System.out.println("preIndex = "+preIndex);
        Node tNode = null;
        if(preIndex<inOrder.length) {
          tNode   = new Node(preOrder[preIndex++]);
        }
        if(start>end)
            return null;
        if(start == end){
            return tNode;
        }
        int inIndex = search(inOrder,start,end,tNode.data);
        System.out.println("start = "+start+" "+ " end = "+end+ " inIndex = "+inIndex);
        tNode.left = buildTree(inOrder,preOrder,start,inIndex-1);
        tNode.right = buildTree(inOrder,preOrder,inIndex+1,end);
        return tNode;
    }

    public static int search(String[] arr,int start, int end, String s ){
        int i;

        for(i = start;i<end;i++){
            if(arr[i] == s)
            return i;
        }
        System.out.println("after i = "+i);
        return i;
    }

}

