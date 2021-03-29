import java.util.*;

public class Main {

    //создадим отдельный класс для записи методов вывода коллекции, добавления элемента и создания самой коллекции
    static class EmailList {

        // возьмем из библитеки константу с регулярным выражением
        private static final String EMAIL_REGEX = "^\\s*?(.+)@(.+?)\\s*$";

        TreeSet<String> emailList = new TreeSet();

        //метод возвращающий список элементов коллекции
        public void printList()
        {
            for (String emailList : emailList){
                System.out.println(emailList);
            }
        }

        //метод добавляющий новый эллемент, в него встроена проверка на коректность эл. адресса
        public void add(String email)
        {
            if(email.matches(EMAIL_REGEX)){
                emailList.add(email);
                System.out.println("Почта успешно добавлена!");
            } else {
                System.out.println("Почта введена некорректно!");
            }
        }
    }

    //статистический метод для вывода введеных значений в консоль
    public static String userInput()
    {
        Scanner input = new Scanner(System.in);
        return (input.nextLine());
    }

    private final static String COMMAND_ADD = "ADD";

    private final static String COMMAND_LIST = "LIST";

    public static void main(String[] args) {
        EmailList emailList = new EmailList();
        for (; ; ) {

            //запишем полученное из метода значения в переменную
            String UserInput = userInput();

            //если введеная строка = ADD заменяем ADD на пустую строку и добавляем в коллекцию оставшийся текст (предварительно проверенный регуляркой)
            if (UserInput.startsWith(COMMAND_ADD)) {
                emailList.add(UserInput.replaceFirst(COMMAND_ADD, "").trim());
            } else if (UserInput.equals(COMMAND_LIST)) {
                emailList.printList();
            } else {
                System.out.println("Неверная команда!");
            }
        }
    }
}