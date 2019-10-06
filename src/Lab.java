//package com.ga.streams
import org.junit.Test;
import com.ga.streams.Employee;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lab {

    private List<Employee> employees = Arrays.asList(
            new Employee("Bezos, Jeff", LocalDate.of(2004, 4, 2), 68_109.00, "Male"),
            new Employee("Sheryl Sandberg", LocalDate.of(2014, 7, 1), 87_846.00,"Female"),
            new Employee("Buffet, Warren", LocalDate.of(2011, 7, 23), 95_035.00, "Male"),
            new Employee("Susan Wojcick", LocalDate.of(2015, 6, 1), 37_210.00, "Female"),
            new Employee("Zuckerberg, Mark", LocalDate.of(2016, 5, 12), 48_450.00, "Male"),
            new Employee("Brin, Sergey", LocalDate.of(2016, 8, 5), 74_416.00, "Male")
    );

//    private static void accept(String employee) {
//        employee.date;
//    }

    private <T> void printList(List<T> list) {
        employees.stream()
                .forEach(emp -> System.out.println(emp));
    }

    @Test
    public void getEmployeesOver50k() {
        List <Employee> over50k = employees.stream()
                .filter(employee -> employee.getSalary() > 50_000)
                .collect(Collectors.toList());

        printList(employees);
    }

    @Test
    public void getEmployeeNamesHiredAfter2012() {
        List<String> employees = null;
        printList(employees);

        List<String> getEmployeeNamesHiredAfter2012 = employees.stream()
                .filter(e -> e.get)
                .collect(Collectors.toList());


    }

    @Test
    public void getMaxSalary() {
        double max = 0;
        System.out.println("Max:" + max);

        Employee personMaxSalary= employees.stream()
                .max(Comparator.comparing(person->person.getSalary()))
                .orElse(null);

    }

    @Test
    public void getMinSalary() {
        double min = 0;
        System.out.println("Min:" + min);

        Employee personMaxSalary= employees.stream()
                .max(Comparator.comparing(person->person.getSalary()))
                .orElse(null);
    }

    @Test
    public void getAverageSalaries() {
        double averageMale = 0;
        double averageFemale = 0;

        averageFemale = employees.stream()
                .filter(person->person.getGender().equals("Female"))
                .mapToDouble(emp -> emp.getSalary())
                .average()
                .orElse(0);

        averageMale = employees.stream()
                .filter(person->person.getGender().equals("Male"))
                .mapToDouble(emp->emp.getSalary())
                .average()
                .orElse(0);






        System.out.println("Averages: Male:" + averageMale + " Female:" + averageFemale);
        System.out.println("Averages: Male:" + averageMale + " Female:" + averageFemale);
    }

    @Test
    public void getMaximumPaidEmployee() {
        Employee highest = null;
        System.out.println(highest);

        Employee personMaxSalary= employees.stream()
                .max(Comparator.comparing(person->person.getSalary()))
                .orElse(null);
    }
}

