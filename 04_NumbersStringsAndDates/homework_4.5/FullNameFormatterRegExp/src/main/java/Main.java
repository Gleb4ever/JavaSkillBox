import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      String [] fIO = input.split("\\s");
      if (!input.matches("[A-Za-zА-Яа-я-]+\\s+[A-Za-zА-Яа-я-]+\\s+[A-Za-zА-Яа-я-]+")){
        System.out.println("Введенная строка не является ФИО");
      } else {
        String name = fIO[0];
        String secondName = fIO[1];
        String lastName = fIO[2];
        System.out.println("Фамилия: " + name);
        System.out.println("Имя: " + secondName);
        System.out.println("Отчество: " + lastName);
      }
      break;
    }
  }
}