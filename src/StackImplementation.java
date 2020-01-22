import java.sql.DatabaseMetaData;

public class StackImplementation {
    public static void main(String[] args){
        /*StackArray s = new StackArray();
        s.push(5);
        s.pop();
        s.pop();
        s.printStack();
        */
        StackUsingLinkedList s = new StackUsingLinkedList();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.pop();
        s.pop();

        s.printStack();
    }
}


class StackArray {
    public static final int MAX = 1000;
    int[] a = new int[MAX];
    int top;
    StackArray(){
        top = -1;
    }

    boolean isEmpty(){
        return top < 0;
    }
    public void push(int x){
        if(top > MAX-1){
            System.out.println("Stack overflow..");
        }
        else{
            a[++top] = x;
        }
    }
    public int pop(){
        if(top<0){
            System.out.println("Stack UnderFlow..");
            return 0;
        }
        else{
            int y = a[top--];
            return y;
        }
    }
    public void printStack(){

        for(int i = top; i>=0; i--){
            System.out.print(a[i]+" ");
        }
    }

}

class Node1 {
    int data;
    Node1 next;
    Node1(int d){
        this.data = d;
    }
}

class StackUsingLinkedList{

    Node1 root;

    public boolean isEmpty(){
        return root == null;
    }
    public void push(int data){
        Node1 newNode = new Node1(data);
        if(root == null)
            root = newNode;
        else{
            Node1 temp = root;
            root = newNode;
            newNode.next = temp;
        }
    }
    public int pop(){
        if(root == null){
            System.out.println("Stack UnderFlow..");
            return 0;
        }
        else {
            int rootData = root.data;
            root = root.next;
            return rootData;
        }
    }
    public void printStack(){
        if(root == null){
            System.out.println("Stack is empty");
        }
        else{
            Node1 temp = root;
            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }
    }
}
