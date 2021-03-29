import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {

  public static void main(String[] args) {
    String text = "Вася   заработал 5000   рублей, Петя - 7563 рубля,   а Маша - 30000 рублей";
  }

  public static int calculateSalarySum(String text)
  {
    int result = 0;
    Matcher matcher = Pattern.compile("\\d+").matcher(text);
    while (matcher.find()){
      int value = Integer.parseInt(matcher.group());
      System.out.print(value + " ");
      result += value;
    }
    System.out.println(result);
    return result;
  }
}