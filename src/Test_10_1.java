
public class Test_10_1 {
    public static void main(String[] args){

     int i = m1();
     System.out.println("i = "+i);
    }
    public static int m1(){
        try{
            System.out.println("hello");
            return 1;
        }
        finally{
            System.out.println("hi");
        }
    }
}
