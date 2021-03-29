import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 180; i++) {
            employees.add(new Operator(null, (Math.random() * (50000 - 30000) + 30000)));
        }

        for (int i = 0; i < 80; i++) {
            employees.add(new Manager(null, (Math.random() * (50000 - 30000) + 30000)));
        }

        for (int i = 0; i < 10; i++) {
            employees.add(new TopManager(null, (Math.random() * (100000 - 70000) + 70000.00)));
        }

        Company company = new Company(10000000.00, employees);

        System.out.println("Список самых высоких зарплат:");
        company.getTopEmployees(30);
        System.out.println();
        System.out.println("Список самых низких зарплат:");
        company.getLowestEmployees(30);
        System.out.println("Количество сотрдуников в компании: " + company.getEmployeesCount(employees));

        for (Employee employee : employees.subList(0, 135)) {
            company.fire(employee);
        }

        System.out.println();
        System.out.println("Список самых высоких зарплат:");
        company.getTopEmployees(10);
        System.out.println();
        System.out.println("Список самых низких зарплат:");
        company.getLowestEmployees(30);
        System.out.println("Количество сотрдуников в компании: " + company.getEmployeesCount(employees));

    }
}
