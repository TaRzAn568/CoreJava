package MultiThreading;

public class OddEvenUsingTwoThread {
    public static void main(String[] args){
        int totalThread = 3;
        int numbers = 30;
        PrintOE printOE = new PrintOE(numbers, totalThread);
        Thread t1 = new Thread(new PrintOESequnece(printOE,0),"Thread-1");
        Thread t2 = new Thread(new PrintOESequnece(printOE,1),"Thread-2");
        Thread t3 = new Thread(new PrintOESequnece(printOE,2),"Thread-3");
        t1.start();
        t2.start();
        t3.start();

    }
}


class PrintOESequnece implements Runnable{
    PrintOE printOE;
    int res;

    PrintOESequnece(PrintOE printOE, int res){
        this.printOE = printOE;
        this.res = res;
    }
    @Override
    public void run(){
        printOE.printNum(res);
    }
}

class PrintOE{
    int n=1;
    int totalNumberInSequence;
    int numberOfThreads;
    PrintOE(int x, int y){
        this.totalNumberInSequence = x;
        this.numberOfThreads = y;
    }

    void printNum(int res) {
        synchronized (this){
            while (n < totalNumberInSequence) {
                while (n % numberOfThreads != res) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    System.out.println(Thread.currentThread().getName()+"_"+ n++);
                    notifyAll();

            }
        }
    }
}

