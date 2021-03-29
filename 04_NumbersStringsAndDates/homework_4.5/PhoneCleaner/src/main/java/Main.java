import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();

      //объявим паттерн для будущего форматироования
      Pattern pattern = Pattern.compile("(?<p1>[0-9]{1})(?<p2>[0-9]{3})(?<p3>[0-9]{3})(?<p4>[0-9]{2})(?<p5>[0-9]{2})");
      if (input.equals("0")) {
        break;
      }

      //вводим новую строку, в которой хранятся только цифры
      String correctForm = input.replaceAll("[^0-9]", "");
      char firstChar = correctForm.charAt(0);

      //проверяем длину строки на кооректность заполнения
      if(correctForm.length() < 10 || correctForm.length() > 11){
        System.out.println("Неверный формат номера");
        break;
      }

      //вводим условие если номер начинается не с 7,8,9.
      if (!String.valueOf(firstChar).equals("7") && !String.valueOf(firstChar).equals("8") && !String.valueOf(firstChar).equals("9")){
        System.out.println("Неверный формат номера");
        break;
      }

      // если длина номера 10 символов, добавляем +7 вначало и форматируем
      if (correctForm.length() == 10) {
        String z = "7" + correctForm;
        Matcher matcher = pattern.matcher(z);
        z = matcher.replaceAll("+${p1} (${p2}) ${p3}-${p4}-${p5}");
        System.out.println(z);
        break;
      }

      //если символов 11, но номер начинается на 9
      if(String.valueOf(firstChar).equals("9")) {
        System.out.println("Неверный формат номера");
        break;
      }

      //если номер начинается с 8-ки, заменим на 7-ку и отформатируем
      if(String.valueOf(firstChar).equals("8")) {
        String d = correctForm.replaceFirst("8", "7");
        Matcher matcher = pattern.matcher(d);
        d = matcher.replaceAll("+${p1} (${p2}) ${p3}-${p4}-${p5}");
        System.out.println(d);
        break;
      }

      // отформатируем номер по нашим требованиям
      Matcher matcher = pattern.matcher(correctForm);
      correctForm = matcher.replaceAll("+${p1} (${p2}) ${p3}-${p4}-${p5}");
      System.out.println(correctForm);
      break;
    }
  }
}


