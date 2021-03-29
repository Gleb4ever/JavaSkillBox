import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        // переведем из String в int, т.к. в конструкторе Cargo предпологается int в методе
        int box = Integer.parseInt(boxes);


        Cargo cargo = new Cargo(box);
        cargo.result();
        System.out.println("Необходимо:" + "\r\nгрузовиков - " + cargo.getTruck() + " шт." +
                "\r\nконтейнеров - " + cargo.getConteiner() + " шт.");
    }
}


