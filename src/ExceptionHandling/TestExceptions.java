package ExceptionHandling;

public class TestExceptions {
    public static void main(String[] args){
        m2();
    }
    static int m1(){
        try{
            System.out.println("Inside try..");
            //System.exit(0);
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

    static void m2(){
        try{
            System.out.println("Inside outer try..");
            try{
                System.out.println("Inside Inner try..");
                int x = 1/0;
            }catch(IllegalArgumentException e){
                System.out.println("IllegalArgumentException."+e);
            }
            finally {
                System.out.println("Inside Inner finally..");
            }

        }catch(ArithmeticException e){
            System.out.println("ArithmeticException.. "+e);
        }
        finally {
            System.out.println("Inside outer finally..");
        }
    }

}
