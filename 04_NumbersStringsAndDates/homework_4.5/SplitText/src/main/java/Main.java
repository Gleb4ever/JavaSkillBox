import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {

  public static void main(String[] args)
  {

    String text = "The Democrat has taken a more measured pace to campaigning than his rival," +
            " spending much of the election cycle at his home in" +
            " Wilmington, Delaware, citing coronavirus restrictions.\n" +
            "\n" +
            "But on Friday he sprinted through Iowa, Wisconsin and Minnesota on his busiest day yet.\n" +
            "\n" +
            "When Mr Biden was last in Iowa, in January, his presidential campaign was in serious" +
            " jeopardy after he was defeated in a party vote to choose the Democratic challenger to Mr Trump.\n" +
            "\n" +
            "Now Mr Biden could be days away from becoming the 46th president of the United States.";

    splitTextInToWords(text);
  }

  public static String splitTextInToWords(String text)
  {
    String reg = "([,-;\\d.\\s+])";
    String newText = "";
    String [] sentences = text.split(reg);
    for (String sentence : sentences) {
      newText = "%s%n%s".formatted(newText, sentence).trim();
    }
    System.out.println(newText);
    return newText;
  }
}