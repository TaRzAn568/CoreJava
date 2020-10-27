package OOPS;

public class ParentChild2 {
    public static void main(String[] dkkkw){
        Parent2 p = new Parent2();
        Child2 c = new Child2();
        System.out.println(( c).str);
        ((Parent2) c).print();
    }

}

class Parent2{
    public String str = "java";
    public static void print(){
        System.out.println("Inside Parent");
    }
}

class Child2  extends Parent2{
    public String str = "Scala";
    public static void print(){
        System.out.println("Inside Child2");
    }
}
