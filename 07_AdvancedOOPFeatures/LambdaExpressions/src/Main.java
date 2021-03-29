import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) throws ParseException {

        ArrayList<Employee> staff = loadStaffFromFile();

        staff.sort((o1, o2) -> {
            int salarySorting = o2.getSalary() - o1.getSalary();
            if (salarySorting != 0) {
                return salarySorting;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("Список сотрудников сортированных по з/п и алфавиту: ");
        staff.forEach(System.out :: println);

        System.out.println();
        System.out.println("Список сотрудников сортированных по з/п, устроившихся в 2017 году: ");
        staff.stream()
                .filter(employee ->{
                    Calendar c = Calendar.getInstance();
                    c.setTime(employee.getWorkStart());
                    return c.get(Calendar.YEAR) == 2018;
                })
                .forEach(System.out::println);
    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return staff;
    }
}