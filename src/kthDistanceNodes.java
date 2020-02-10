import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/*class Node{
    String data;
    Node right;
    Node left;

    Node(String item){
        data = item;
    }
}*/

public class kthDistanceNodes {
    private static class Node{
        String data;
        Node right;
        Node left;

        Node(String item){
            this.data = item;
        }
    }
    public static void  main(String[] args)throws IOException,Exception{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        //int t = Integer.parseInt(br.readLine());
        //String [] inOrder = br.readLine().split(" ");
        //String [] preOrder = br.readLine().split(" ");

        /*String [] inOrder = new String[] {  "D","B","E","A", "F", "C" };
        String [] preOrder = new String[] { "A", "B", "D", "E", "C", "F" };
        */
 /*       String [] inOrder = new String[] {  "P","H","D","I", "B", "J","E","K","A","R", "L", "F", "M","C","N","G","O", "Q"};
        String [] preOrder = new String[] { "A","B","D","H", "P", "I","E","J","K","C", "F", "L", "R","M","G","N","O", "Q" };
*/

        String [] inOrder = new String[] {  "8","4","9","2","10","5","11","1","12","6","13","3","14","7","15" };
        String [] preOrder = new String[] { "1","2","4","8","9","5","10","11","3","6","12","13","7","14","15" };

        Node tNode = buildTree(inOrder, preOrder,0,inOrder.length-1);

        /*Map<Integer,List<String>> returnMap = getNodesAtKthDistance(tNode,0,null);
        int k=3;
        System.out.println("Nodes at "+k+" distance = "+returnMap.get(k).toString().replaceAll("\\[|\\]","").trim());
*/

        //printAncestors(tNode,tNode,"Q");
        //int res = getLevel(tNode,"E");
        //System.out.println("res = "+getLevelDiff(tNode));
        //getAllNodeSum(tNode);

    }
    Node root;
    static int preIndex = 0;

    /**This method buildTree from givin inorder and preOrder traversal
     * Recursive approach
     * @param inOrder
     * @param preOrder
     * @param start
     * @param end
     * @return
     * @throws Exception
     */
    public static Node buildTree(String[] inOrder, String[] preOrder, int start, int end)throws Exception{
        //Thread.sleep(1000);
        Node tNode = null;
        if(preIndex<inOrder.length && start<=end) {
            tNode   = new Node(preOrder[preIndex++]);
            //System.out.println("tNode = "+tNode.data);
        }
        else{
            return null;
        }
        if(start == end){
            return tNode;
        }
        int inIndex = search(inOrder, start, end, tNode.data);
        tNode.left = buildTree(inOrder, preOrder, start, inIndex - 1);
        tNode.right = buildTree(inOrder, preOrder, inIndex + 1, end);
        return tNode;
    }

    public static int search(String[] arr,int start, int end, String s ){
        int i;
        for(i = start;i<end;i++){
            if(arr[i] == s)
                return i;
        }
        return i;
    }

    public static Map<Integer,List<String>> getNodesAtKthDistance(Node root,int level ,Map<Integer,List<String>> returnMap){
        if(returnMap == null){
            returnMap = new HashMap<Integer,List<String>>();
        }
        if(root == null) return null;
        List<String> tempList = null;
        if(returnMap.get(level) == null){
            tempList = new ArrayList<String>();
            tempList.add(root.data);
        }
        else{
            tempList = returnMap.get(level);
            tempList.add(root.data);
        }
        returnMap.put(level,tempList);
        getNodesAtKthDistance(root.left, level+1 ,returnMap);
        getNodesAtKthDistance(root.right, level+1 ,returnMap);

        return returnMap;
    }

    public static boolean printAncestors(Node node,Node node1, String x)
    {
        if(node == null) return false;
        if(x == node.data) return true;
        if(printAncestors(node.left,node1,x) || printAncestors(node.right,node1,x)){
            System.out.print(node.data+" ");
            printAncestors(node1,node1,node.data);

        }
        return false;
    }
    public static int getLevel(Node node, String key){
        return getLevelUtil(node,"I","lr");
    }
    public static int getLevelUtil(Node node, String key, String lr)
    {   //if(node != null)
        //System.out.println("node.data = "+node.data+" lr = "+lr);
        if(node==null) return 0;
        if(node.data==key) return 1;
        int left = getLevelUtil(node.left, key, "L");
        //System.out.println("left = "+left);
        int right = getLevelUtil(node.right, key, "R");
        //System.out.println("right = "+right);
        if(left==0 && right==0) return 0;
        int res = 0;
        if(left==0) {
            System.out.println("Right ");
            res =  right+1;}
        if(right==0){
            System.out.println("Left ");
            res =  left+1;}

        return res;
    }

    /** https://practice.geeksforgeeks.org/problems/odd-even-level-difference/1
     *  non recursive Soln of getting the diff. of sum of odd level nodes and even level nodes (oddSum - evenSum)
     * @param root
     * @return
     */
    public static int getLevelDiff(Node root)
    {
        if(root == null) return 0;
        Queue<Node> q = new LinkedList();
        q.add(root);
        int i=2,oddSum=Integer.parseInt(root.data),evenSum=0;
        while(!q.isEmpty()){
            int c = q.size();
            for(int j=0; j<c; j++){
                Node temp = q.poll();
                if(temp.left != null){
                    q.add(temp.left);
                    if(i%2 == 0)
                        evenSum += Integer.parseInt(temp.left.data);
                    else
                        oddSum += Integer.parseInt(temp.left.data);
                }
                if(temp.right != null){
                    q.add(temp.right);
                    if(i%2 == 0)
                        evenSum += Integer.parseInt(temp.right.data);
                    else
                        oddSum += Integer.parseInt(temp.right.data);
                }
            }
            i++;
        }
        return oddSum-evenSum;
    }
/*public static int getAllNodeSum(Node root){
        if(root == null) return 0;
        Node left = getAllNodeSum(root.left);
        int leftData = Integer.parseInt(left.data);
        Node right = getAllNodeSum(root.right);
        int rightData = Integer.parseInt(right.data);

        int sum = leftData + rightData;

        System.out.println("sum = "+sum);
        return sum;
}*/


}
