import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;



public class TreeFromPreOrderAndInOrder {
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
        /*String [] inOrder = new String[] {  "P","H","D","I", "B", "J","E","K","A","R", "L", "F", "M","C","N","G","O", "Q"};
        String [] preOrder = new String[] { "A","B","D","H", "P", "I","E","J","K","C", "F", "L", "R","M","G","N","O", "Q" };
        */


        String [] inOrder = new String[] {  "2","1"};
        String [] preOrder = new String[] { "1","2" };

        Node tNode = buildTree(inOrder, preOrder,0,inOrder.length-1);
        Map maxNodeLevelMap = maxNodeLevel(tNode);
        System.out.println("maxNodeLevel map = "+maxNodeLevelMap);
        int maxNodeLevel = findMaxNodeLevel(maxNodeLevelMap);
        System.out.println("maxNodeLevel = "+maxNodeLevel);

        Map returMap = getMaxWidthUtil(tNode , 0, null);
        System.out.println("returMap = "+returMap);



    }
    static int max = -1;
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
        System.out.println("start = "+start+" end = "+end);
        //Thread.sleep(1000);
        Node tNode = null;
        if(preIndex<inOrder.length && start<=end) {
            tNode = new Node(preOrder[preIndex++]);
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

    /**This Method returns the map which contains number of nodes at each level
     * Iterative approach using 2 List and 1 map
     * @param node
     * @return
     */

    public static Map maxNodeLevel(Node node){
        List<Node> l1 = new ArrayList<Node>();
        List<Node> l2 = new ArrayList<Node>();
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        if(node != null){
            l1.add(node);
            m.put(0,1);
        }int i=1;
        while(l1.size()>0){
            for(Node n : l1){
                if(n.left != null)
                    l2.add(n.left);
                if(n.right != null)
                    l2.add(n.right);
            }
            l1.removeAll(l1);
            if(l2.size()>0) {
                l1.addAll(l2);
                l2.removeAll(l2);
                m.put(i,l1.size());
                i++;
            }
            else{
                break;
            }
        }
        System.out.println("Map m = "+m);
        return m;
    }

    /**This method returns the key which contains the max value where each value is +ve number
     *
     * @param map
     * @return
     */
    public static int findMaxNodeLevel(Map<Integer,Integer> map){
        int max = 0;
        int maxIndex = -1;
        for(Integer key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                maxIndex = key;
            }
        }
        return maxIndex;
    }

    /**This Method returns the map which contains number of nodes at each level
     * Recursive approach
     * @param root
     * @param level
     * @param returnMap
     * @return
     */
   /* public static Map getMaxWidthUtil(Node root, int level, Map returnMap){
        if(returnMap == null){
            returnMap = new HashMap();
        }
        if(root == null) {
            return null ;
        }
        returnMap.put(level,(int)returnMap.getOrDefault(level,0)  + 1);
        getMaxWidthUtil(root.left, level+1, returnMap);
        getMaxWidthUtil(root.right, level+1, returnMap);
        return returnMap;
    }*/

    /**This method returns the maximum width of binary tree
     *Recursive Approach
     * https://practice.geeksforgeeks.org/problems/maximum-width-of-tree/1/
     * @param root
     * @param level
     * @param returnMap
     * @param max
     * @return
     */
    public static Map getMaxWidthUtil(Node root, int level, Map returnMap){
        if(returnMap == null){
            returnMap = new HashMap();
        }
        if(root == null) return null;
        returnMap.put(level,(int) returnMap.getOrDefault(level,0)+1);
        getMaxWidthUtil(root.left, level+1,returnMap);
        getMaxWidthUtil(root.right, level+1,returnMap);
        return returnMap;
    }
}

