package MultiThreading;

public class FizzBuzz {

    public static void main(String[] args)throws Exception{
        Thread t1 = new Thread(new Fizz());
        Thread t2 = new Thread(new Buzz());
        t1.start();
        t2.start();
    System.out.println();
    }
}


class Fizz implements Runnable
{
    @Override
    public void run(){
        while (true){

            System.out.print("Fizz ");
        }
    }
}

class Buzz implements Runnable
{
    @Override
    public void run(){
        while (true){
            System.out.print("Buzz ");
        }
    }
}