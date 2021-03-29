import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        String[] chars = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х",};
        int beautyNum = 0;
        String saveBeautyNum = "";
        for (int i = 1; i < 130; i++) {
            for (String letterA : chars) {
                for (String letterB : chars) {
                    for (String letterC : chars) {
                        for (int num = 1; num < 1000; num++) {
                            if (num == 111 || num == 222 || num == 333 || num == 444 || num == 555 || num == 666 || num == 777 || num == 888 || num == 999) {
                                beautyNum = num;
                                list.add(letterA + beautyNum + letterB + letterC + String.format("%02d", i));
                                System.out.println(letterA + beautyNum + letterB + letterC + String.format("%02d", i));
                            }


                        }
                    }
                }
            }
        }

        HashSet<String> set = new HashSet<>(list);
        TreeSet<String> treeSet = new TreeSet<>(list);
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {

            // поиск обычным перебором
            String input = scanner.nextLine();
            System.out.println("Поиск перебором: ");
            long start = System.nanoTime();
            if (list.contains(input)) {
                System.out.print(" Найдено ");
            } else {
                System.out.print(" Не найденно ");
            }
            long duration = System.nanoTime() - start;
            System.out.print("Поиск занял: " + duration + " нано секунд ");
            System.out.println();

            //поиск в HashSet
            System.out.println("Поиск в HashSet: ");
            long start1 = System.nanoTime();
            if (set.contains(input)) {
                System.out.print(" Найдено ");
            } else {
                System.out.print(" Не найденно ");
            }
            long duration1 = System.nanoTime() - start1;
            System.out.print("Поиск занял: " + duration1 + " нано секунд ");
            System.out.println();

            //поиск в TreeSet
            System.out.println("Поиск в TreeSet: ");
            long start2 = System.nanoTime();
            if (treeSet.contains(input)) {
                System.out.print(" Найдено ");
            } else {
                System.out.print(" Не найденно ");
            }
            long duration2 = System.nanoTime() - start2;
            System.out.print("Поиск занял:  " + duration2 + " нано секунд");
            System.out.println();

            //поиск бинарным перебором
            System.out.println("Поиск бинарным перебором: ");
            Collections.sort(list);
            long start3 = System.nanoTime();
            int binary = Collections.binarySearch(list, input);
            if (binary >= 0) {
                System.out.print(" Найдено ");
            } else {
                System.out.print(" Не найденно ");}
                long duration3 = System.nanoTime() - start3;
                System.out.print("Поиск занял: " + duration3 + " нано секунд");
            }
        }
    }