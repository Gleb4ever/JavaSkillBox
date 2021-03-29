import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите путь к папке для копирования: ");
            String firstInput = scanner.nextLine();
            File firstFolder = new File(firstInput);

            System.out.println("Введите путь к папке для вставки: ");
            String secondInput = scanner.nextLine();
            File secondFolder = new File(secondInput);

            copy(firstFolder,secondFolder);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static void copy(File sourceLocation, File targetLocation)
    {
        try {


            if (sourceLocation.isDirectory()) {
                copyDirectory(sourceLocation, targetLocation);
            } else {
                copyFile(sourceLocation, targetLocation);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private static void copyDirectory(File source, File target)
    {
        try {
            for (String f : source.list()) {
                copy(new File(source, f), new File(target, f));
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private static void copyFile(File source, File target)
    {
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target)
        ) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
