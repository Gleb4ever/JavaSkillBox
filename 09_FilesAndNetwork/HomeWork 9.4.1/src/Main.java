import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Main {

    //создадим константу с путем к папке назначения
    private final static String IMAGE_FOLDER = "C:\\Users\\User\\java_basics\\09_FilesAndNetwork\\HomeWork 9.4.1\\images";

    //создадим константу ссылка на лента.ру
    private final static String STR_URL = "http://lenta.ru";

    //создадим константу с регулярным выражением, для проверки формата изображения
    private final static String IMG_REGEX = "img[src~=(?i)\\.(png|gif|jpe?g)]";

    public static void main(String[] args) throws IOException
    {
        //получим HTML код сайта
        Document doc = Jsoup.connect(STR_URL).get();

        //сохраним в переменную все изображения с сайта по тэгу img
        Elements imageElements = doc.select(IMG_REGEX);

        //c помощью цикла получим каждую ссылку на изображение
        for(Element imageElement : imageElements){

            String strImageURL = imageElement.attr("abs:src");

            //сохраним изображение в папку img с помощью метода downloadImage
            downloadImage(strImageURL);
        }
    }

    private static void downloadImage(String strImageURL)
    {
        //получим оригинальное название изображения
        String strImageName = strImageURL.substring(strImageURL.lastIndexOf("/") + 1);

        System.out.println("Сохранено: " + strImageName + ", из: " + strImageURL);

        try
        {
            // откроем stream через URL
            URL urlImage = new URL(strImageURL);
            InputStream in = urlImage.openStream();

            //создадим буффер для хранения изображения перед записью
            byte[] buffer = new byte[4096];

            OutputStream os = new FileOutputStream( IMAGE_FOLDER + "/" + strImageName );

            //запишем файлы
            int n;
            while (-1 != ( n = in.read(buffer) )) {
                os.write(buffer, 0, n);
            }
            //закроем запись
            os.close();

            System.out.println();
            System.out.println("Изображение сохранено!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
