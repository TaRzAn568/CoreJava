package ExceptionHandling;

public class TestExceptions {
    public static void main(String[] args){
        System.out.println(m1());
    }
    static int m1(){
        try{
            System.out.println("Inside try..");
            System.exit(0);
            System.out.println("After exit..");
            return 2;
        }
        catch (Exception e){
            System.out.println("Inside catch.."+e);
            return 1;
        }
        finally {
            System.out.println("Inside finally..");
        }
    }


}
