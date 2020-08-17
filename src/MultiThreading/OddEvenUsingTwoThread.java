/*
package MultiThreading;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

public class OddEvenUsingTwoThread {
public static void main(String[] args){
    Thread t1 = new Thread(new Thread1());
    Thread t2 = new Thread(new Thread2());
    t1.start();
    t2.start();

}
}

class Thread1 implements Runnable{
    public void run(){
        for(int i=1; i<=20; i=i+2){

             synchronized (Thread1.class) {
                Thread1.wait();
                System.out.print(i + " ");
            }
        }
    }
}

class Thread2 implements Runnable{
    public void run(){
        for(int i=2; i<=20; i=i+2){
            System.out.print(i+" ");
        }
    }
}
*/
