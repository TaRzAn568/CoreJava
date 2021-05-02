package Java8;

import java.io.*;
import java.util.*;

class Employee implements Serializable{
    int empId;
    String ename;


    Employee(int id, String name){
        this.empId = id;
        this.ename = name;
    }

}




class Main{

    public static void main(String [] ars){

        Employee e1 = new Employee(1,"Ved");
        Employee e2 = new Employee(2,"dev");

        List<Employee> empList = new ArrayList<>();
        empList.add(e1);

        System.out.println(e1);
    }
}

