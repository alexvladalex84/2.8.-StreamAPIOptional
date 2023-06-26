import pro.sky.homework2_8streamapioptional.Model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        System.out.println(getEmployee());
        List<Employee> employee = Test.getEmployee();
//
//        List<Employee> em1 = em.stream()              //создаем поток "Стрим"из листа em ,,к ем применяем .стрим
////                .filter(e -> e.getSalary() < 16000)                 //далее КОНВЕЕРНЫЙ "ФИЛЬТР" метод для стрим фильтруем у кого зп меньше 17т
//                .map(e -> new Employee(e.getFirstName(),e.getLastName(), "Вл",e.getSalary()+10000,e.getDepartment()))
//                .collect(Collectors.toList());                     //коллект ТЕРМИНАЛЬНЫЙ метод данные превращает в коллекцию
//

//                  Employee employee1 = employee.stream()
////                .filter(e ->e.getSalary()>10000)
//
//                .max(Comparator.comparing(Employee::getSalary))
//                .get();

//        List<Employee>employee1 = employee.stream().filter(e->e.getDepartment() == 2).collect(Collectors.toList());

//        List<Employee>employee1 = employee.stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors.toList());

//        List<String> strings = employee.stream()
//                .map((Employee e) -> {return e.getLastName();})
//                        .collect(Collectors.toList());






//employee1.forEach(e ->System.out.println(e));
//        System.out.println(employee1);
//        em1.forEach(e -> System.out.println(e));
//        em1.forEach(System.out::println);

//        for (int i = 0; i < em1.size();i++) {
//            System.out.println(em1.get(i));
//        }
    }

    public static List<Employee> stringList = new ArrayList<>();
    static{
        Employee employee1 = new Employee("Саша","Саша","Сашва",5000,2);
        Employee employee2 = new Employee("Саш","Саш","Сашв",5000,2);
        Employee employee3 = new Employee("Са","Са","Саш",16000,1);
        Employee employee4 = new Employee("С","С","С",16000,4);
        Employee employee5 = new Employee("Сша","Сша","Сшва",17000,1);
        stringList.add(employee1);
        stringList.add(employee2);
        stringList.add(employee3);
        stringList.add(employee4);
        stringList.add(employee5);
    }

    public static List<Employee> getEmployee() {
        return stringList;
    }

}
