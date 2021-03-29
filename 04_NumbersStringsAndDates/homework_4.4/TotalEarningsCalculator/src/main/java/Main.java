import javax.sound.sampled.Line;

public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    String line = "-";

    int firstChar = text.indexOf("заработал");

    firstChar = text.indexOf(" ", firstChar);

    int firstCharEnd = text.indexOf("рубл");

    int firstMoney = Integer.parseInt(text.substring(firstChar + 1, firstCharEnd).trim());

    int secondMoney = Integer.parseInt(text.substring(text.lastIndexOf(line) + line.length(), text.lastIndexOf("рубл")).trim());

    int lastMoney = Integer.parseInt(text.substring(text.indexOf(line) + line.length(), text.indexOf("рубля")).trim());

    int allMoney = firstMoney + secondMoney + lastMoney;

    System.out.println(allMoney);

  }
}

