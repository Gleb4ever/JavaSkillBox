import java.util.*;
public class Main {

    //создадим отдельный метод для получния введеной в консоль строки
    public  static String nameOrPhoneInput()
    {
        Scanner input = new Scanner(System.in);
        return (input.nextLine());
    }

    //создадим метод проверяющий являетя ли строка телефонным номером
    public static boolean chekInputIsPhone(String input)
    {
        return input.matches("^((8|\\+7)[\\-]?)?(\\(?\\d{3}\\)?[\\-]?)?[\\d\\-]{7,10}$");
    }

    //создадим метод проверяющий являетя ли строка имененм контакта
    public static boolean chekInputIsName(String input)
    {
        return input.matches("^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$");
    }

    public static void main(String[] args) {

        //создадим коллекцию Телфонная Книга
        TreeMap<String, String> phoneBook = new TreeMap<String, String>();

        boolean containsKey = false;
        boolean containsValley = false;


        while (true) {
            String firstInput = nameOrPhoneInput();

            //создадим два условия которые запишем в переменные
            if(phoneBook.containsKey(firstInput)){
                containsKey = true;
            }
            if (phoneBook.containsValue(firstInput)){
                containsValley = true;
            }

            //если строка является LIST распечатаем коллекцию в алфавитном порядке и ключе в виде телфонного номера
            if (firstInput.equals("LIST")) {
                Map sortedMap = sortByValues(phoneBook);
                Set set = sortedMap.entrySet();
                Iterator it = set.iterator();
                System.out.println("Телефонная книга содержит: ");
                while(it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    System.out.print("Номер: "+pair.getKey() + " и ");
                    System.out.println("Имя: "+pair.getValue());
                }
            }

            //если строка не является ключом и значением добавляем в коллекцию новый номер и имя
            else if (!(containsKey) && (!(containsValley)) && chekInputIsName(firstInput)){
                System.out.println("Введите номер контакта!");
                String secondInput = nameOrPhoneInput();
                if (chekInputIsPhone(secondInput)){
                    phoneBook.put(secondInput, firstInput);
                    System.out.println("Новый контакт успешно добавален!");
                } else {
                    System.out.println("Некорректно введен номер контакта!");
                }
            } else if (!(containsKey) && (!(containsValley)) && chekInputIsPhone(firstInput)){
                System.out.println("Введите имя контакта!");
                String secondInput = nameOrPhoneInput();
                if (chekInputIsName(secondInput)){
                    phoneBook.put(firstInput, secondInput);
                    System.out.println("Новый контакт успешно добавален!");
                } else {
                    System.out.println("Некорректно введено имя контакта!");
                }
            }

            //если строка является ключом и при этом соответсвует номеру печатаем имя и номер контакта
            else if(containsKey && chekInputIsPhone(firstInput)){
                System.out.println("Имя: " + phoneBook.get(firstInput) + " Номер: " + firstInput);
            }

            //если строка является значением и при этом соответсвует имени печатаем имя и номер контакта
            else if(containsValley && chekInputIsName(firstInput)){
                for (Object o : phoneBook.keySet()){
                    if (phoneBook.get(o).equals(firstInput)){
                        System.out.println("Имя: " + firstInput + " Телефон: " + o);
                    }
                }
            }
        }
    }

    //создадим метод для сортировки телефонной книги по значению
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map)
    {
        Comparator<K> valueComparator = new Comparator<K>()
        {
            public int compare(K k1, K k2) {
                int compare =
                        map.get(k1).compareTo(map.get(k2));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };
        Map<K, V> sortedByValues =
                new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}

