public class Main {

    public static void main(String[] args) {

        String cardCode = "<3214 4213 4124> 3231";
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder)
    {

        int i1 = 0;
        int i2;
        while (true) {
            i1 = text.indexOf('<', i1);
            if (i1 == -1) {
                break;
            }

            i2 = text.indexOf(">", i1);

            if (i2 == -1) {
                break;
            }

            int i3 = text.indexOf('<', i2);

            if (i3 == -1) {
                i3 = text.length();
            }

            i2 = text.substring(i1, i3).lastIndexOf(">");
            i2 += i1;
            text = text.substring(0, i1) + placeholder + text.substring(i2 + 1);
        }
        return text;
    }
}