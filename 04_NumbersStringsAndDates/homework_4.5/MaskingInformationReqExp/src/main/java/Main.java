import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {

    public static String searchAndReplaceDiamonds(String text, String placeholder)
    {
        text = text.replaceAll("<.+?>", placeholder);
        return text;
    }
}

