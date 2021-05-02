package Java8;

import java.io.Serializable;
import java.util.*;

class Address implements Serializable{
    String street;
    Address(String street){
        this.street = street;
    }
}
final class Immutibility implements Serializable{

   final int id;
   final String name;
   final Address add;

   Immutibility(int id, String name, Address add){
       this.id = id;
       this.name = name;
       this.add = new Address(add.street);
   }


}

class ImmutibilityMain{
    public static void main(String[] args){
        Address add = new Address("Madai Chowk");
        Immutibility imm = new Immutibility(1,"Ved",add);
        System.out.println("here = "+imm);
        System.out.println(imm.id +"_"+imm.name+"_"+imm.add.street);
        add.street = "kali Sdak";
        System.out.println(imm.id +"_"+imm.name+"_"+imm.add.street);


    }
}