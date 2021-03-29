import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }
    //создадим метод, возвращащий день рождения, основываясь на переданную дату рождения начиная с 0
    public static String collectBirthdays(int year, int month, int day)
    {
        //отнимем один месяц, от изначальноой int переменной, т.к. в классе calendar отчёт месяцов идёт с 0.
        month = month -1;

        //установим формат 21.04.1995 - Thu
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - E", Locale.ENGLISH);

        //создадим новый календарь и передадим в него значения переданные в метод
        Calendar calendar = new GregorianCalendar(year, month, day);

        //создадим новый календарь, отображающий текущую дату
        Calendar calendar1 = Calendar.getInstance();

        //создадим переменные для сохранения даты ДР.
        int i = 0;
        String x = "";
        while (calendar.before(calendar1)){
            if (i >= 1){
                x = x + "\n";
            }

            //используем конкатенацию строк в одну строку
            x = x + i + " - " + dateFormat.format(calendar.getTime());
            i++;
            calendar.add(Calendar.YEAR, +1);
        }
        return x;

    }
}
