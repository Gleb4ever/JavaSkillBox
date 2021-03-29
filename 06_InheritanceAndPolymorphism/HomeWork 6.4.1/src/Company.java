import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {

    private double income;

    private List<Employee> employees = new ArrayList<>();

    public Company(double income, List<Employee> employees)
    {
        this.income = income;
        for (Employee employee : employees) {
            employee.setCompany(this);
        }
        this.employees.addAll(employees);
    }

    public void hire(Employee employee)
    {
        employees.add(employee);
    }

    public void fire(Employee employee)
    {
        employees.remove(employee);
    }

    public double getIncome()
    {
        return income;
    }

    public void hireAll(List <Employee> employees)
    {
        this.employees.addAll(employees);
    }


    public void sortEmployees(int count, Comparator<Employee> comparator)
    {
        if(count > 0 && count <= employees.size()){
            employees.sort(comparator);
            for (int i = 0; i <= count - 1 ; i++){
                System.out.println(employees.get(i).getMonthSalary() + " рублей.");
            }
        } else {
            System.out.println("Введено неккоректное число!");
        }
    }

    public void getLowestEmployees(int count)
    {
        sortEmployees(count, new Comparator<Employee>(){
            public int compare(Employee o1, Employee o2){
                return Double.compare(o1.getMonthSalary(), o2.getMonthSalary());
            }
        });
    }

    public void getTopEmployees (int count)
    {
        sortEmployees(count, new Comparator<Employee>(){
            public int compare(Employee o1, Employee o2){
                return Double.compare(o2.getMonthSalary(), o1.getMonthSalary());
            }
        });
    }

    public int getEmployeesCount(List<Employee> employees)
    {
        return this.employees.size();
    }

}
