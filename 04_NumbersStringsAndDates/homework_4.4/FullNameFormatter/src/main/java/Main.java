import java.util.Scanner;
public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true){
      String input = scanner.nextLine().trim();
      if (input.equals("0")){
        break;
      }

      int spaceCount = 0;
      boolean isCorrect = false;

      for(int i = 0; i < input.length();i++){
        char c = input.charAt(i);
        if (c == ' '){
          spaceCount++;
        } else if {
          (!((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я') || c == 'Ё' || c == 'ё' || c == '-'))
        } else {
          isCorrect = true;
          break;
        }
      }

      if (spaceCount != 2 || isCorrect) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }

      int firstIndex = input.indexOf(" ");
      int lastIndex = input.lastIndexOf(" ");

      String firstName = input.substring(0, firstIndex);
      String lastName = input.substring(firstIndex + 1, lastIndex);
      String otherName = input.substring(lastIndex + 1);

      System.out.println("Фамилия: " + firstName);
      System.out.println("Имя: " + lastName);
      System.out.println("Отчество: " + otherName);
    }
  }
}

