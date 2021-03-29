import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // создадим отдельно список дел
    public static ArrayList<String> toDoList = new ArrayList<>()
    {
        {
            //добавим в список дела
            add("Помыть машину");
            add("Заправить машину");
            add("Заменить масло в коробке");
            add("Поставить машину на стоянку");
        }
    };

    //создадим отдельный метод comm для получения первого введенного слова (которое будет являться одной из 5-ти команд)
    public static String comm(String[] string)
    {
        return  string[0].trim();
    }

    // создадим отдельный метод для получения номера индекса дела, которое будет измененно, удалено или добавлено
    public static int ind (String[] string)
    {
        return Integer.parseInt(string[1].trim());
    }

    //создадим отдельный метод для получения строки с текстом дела (в случае добавления или изменения)
    public static String scanToDoList(String[] string, int index)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = index; i < string.length; i++){
            stringBuilder.append(string[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }


    public static void main(String[] args) {

        //добавим новый сканер
        Scanner scanner = new Scanner(System.in);
        String input = " ";


        //создадим цикл while с условием, если введенно слово не является EXIT
        while (!input.equals("EXIT")){
            System.out.println("Введите команду или \"EXIT\" для завершения: ");
            input = scanner.nextLine();

            //создадим массив, хранящий по словно введенную в консоль строку
            String[] commands = input.split("\\s+");

            // создадим перменные, для записи полученных из методов значения
            String command = " ";
            String toDo = "null";
            int index = -1;

            //используем регулярные выражения для обнаружения первого введенного слова (только большие буквы)
            if(input.matches("^[\\p{Upper}]+")){
                command = input.trim();
            }
            //если введены только большие буквы пробел и цифры, то занесем значения букв в команду, а цифры в значение индекса дела
            else if (input.matches("^[\\p{Upper}]+\\s+\\d+")) {
                command = comm(commands);
                index = ind(commands);
            }
            // если введены большие буквы, пробел и цифры, а после сколько угодно букв, выедлим отедльно команду и отдельно текст добавляемого дела
            else if(input.matches("^[\\p{Upper}]+\\s+\\d+.+")) {
                command = comm(commands);
                index = ind(commands);
                toDo = scanToDoList(commands,2);
            }

            // если введены большие буквы и сколько угодно других символов, записываем большие буквы в команду, а все символы в текст дела
            else if (input.matches("^[\\p{Upper}]+.+")) {
                command = comm(commands);
                toDo = scanToDoList(commands,1);
            }
            else {System.out.println("Неверная команда");}

            //используем switch для операций в консоле, т.к. в переменную command записывались введенные команды, запускается одна из 5 задач
            switch (command){

                //распечатаем в консоль все дела хранящиеся в списке
                case ("LIST"):
                    System.out.println("Список дел: ");
                    for (int i = 0; i < toDoList.size(); i++){
                        System.out.println("Работа номер: " + i + " " + toDoList.get(i));}
                    break;

                /* если мы записали в перменную index значение и это значение меньше кол-ва дел в списке
                то добавляем новое дело (значение для которого записывались в перменные index */
                case ("ADD"):
                    if (index > -1 && index < toDoList.size()) {
                        toDoList.add(index, toDo);
                        System.out.println("Добавлена работа \"" + toDo + "\" с индексом " + index);
                    }

                    // если значение индекса привышает кол-во дел в списке, выдаём ошибку и отображаем необходимый индекс для дела
                    else if (index > toDoList.size()) {
                        System.out.println("Укажите индекс не более " + (toDoList.size() - 1));
                    }
                    else {toDoList.add(toDo);
                    }
                    break;

                /* всё тоже самое, что в пердыдущем кейсе, только вместо добавления нового дела, изменяем существующее
                  опять же чере укзанные значения в index  */
                case ("EDIT"):
                    if(index > -1 && index < toDoList.size()) {
                        toDoList.set(index, toDo);
                        System.out.println("Работа под индексом " + index + " изменена на \"" + toDo + "\"");
                    }
                    // пишем ошибку, если такого дела не существует и указываем текущее кол-во дел
                    else {
                        System.out.println("Неверная команда. Укажите индекс редактируемого дела " +
                                " значением не более " + (toDoList.size() - 1));
                    }
                    break;

                // удаляем дело, с помощью записанного в index значения
                case ("DELETE"):
                    if(index > -1 && index < toDoList.size()) {
                        toDoList.remove(index);
                        System.out.println("Работа с индексом " + index + " удалена");
                    }

                    //если нет дела под указанным индексом, пишем ошибку и выводим текущее кол-во дел
                    else {System.out.println("Неверная команда. Укажите индекс удаляемого дела" +
                            " значением не более " + (toDoList.size() - 1));
                    }
                    break;

                //кейс для выхода из консоли
                case ("EXIT"):
                    System.out.println("Работа завершена.");
                    break;

                //по умолчанию пишем, что введенная команда отсутствует и пишем доступные для ввода комманды
                default:
                    System.out.println("Такой команды нет. \nДоступные команды: LIST, ADD, EDIT, DELETE.");
            }
        }
    }
}





