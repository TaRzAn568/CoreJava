package Matrix;


class Node1{
    int data;
    Node1 next;
    Node1(int d){
        this.data = d;
    }
}



public class NthElementFromLastInLL {

public static void main(String[] KJDJ){
    Node1 ll = new Node1(1);
    ll.next = new Node1(2);
    ll.next.next = new Node1(3);
    ll.next.next.next = new Node1(4);
    ll.next.next.next.next = new Node1(5);
    ll.next.next.next.next.next = new Node1(6);


    Node1 temp = ll;
    int n = 2;
    fun(ll,n);
}

static int c = 1;
// fast = nth slow =
public static void fun(Node1 node,int n){
    if(node == null){
        return ;
    }
     fun(node.next,n);
    if(c == n){
        System.out.println("nth from last = "+node.data);
    }else{

    }
    c++;
}


}
