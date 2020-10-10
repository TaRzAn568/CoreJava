package OOPS;

public class NestedClassDemo {
    public static void main(String[] args){
        System.out.println("Inside class NestedClassDemo");

        //P p = new P();
       new P().new C2().new C3().new C4().mC4();
       // c1.mC1();

    }
}

class P{
    void mP() {
        System.out.println("Inside class P");
    }
    class C1{
        void mC1(){
            System.out.println("Inside class C1");
        }
    }
        class C2{
            void mC2() {
                System.out.println("Inside class C2");
            }
            class C3{
                void mC3() {
                    System.out.println("Inside class C3");
                }
                class C4{
                    void mC4() {
                        System.out.println("Inside class C4");
                    }
                }
            }
        }
    }

