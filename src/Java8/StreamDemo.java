//package Java8;

import sun.security.krb5.KrbException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    int id;
    String name;
    int age;
    double salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;

        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {

        this.id = id;
    }
}
class StreamDemo {

    public static void main(String[] args){
        List<Employee> empList = createEmployee();

        List<Employee> filteredList =
                        empList.stream()
                        .filter(x-> x.salary >= 45000)
                        .filter(x-> x.age >= 25)
                        .sorted((o1, o2)->(o1.salary > o2.salary ? 1 :-1))
                        .collect(Collectors.toList());
        //.forEach(x-> System.out.println(x.id+" "+x.name+" "+x.age+" "+x.salary));

        for (Employee x : filteredList)
            System.out.println(x.id+" "+x.name+" "+x.age+" "+x.salary);
    }

    public static List<Employee> createEmployee(){
        List<Employee> empList = new ArrayList<>();
        Employee e = new Employee();
        e.setId(1);
        e.setName("Ram");
        e.setAge(22);
        e.setSalary(1213);

        empList.add(e);
        empList.add(new Employee(2,"Ved",25,50000));
        empList.add(new Employee(3,"Ajit",24,30000));
        empList.add(new Employee(4,"Kumar",28,40000));
        empList.add(new Employee(5,"Dova",27,45000));
        empList.add(new Employee(6,"Amar",31,52000));
        empList.add(new Employee(7,"Shyam",29,44000));


        //System.out.println(e.id +" "+ e.name+" "+e.age+" "+e.salary);
        return empList;
    }
}
