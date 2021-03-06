import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class Loader
{
        public static long start;

        public static void main(String[] args) throws Exception
        {

            String fileName = "res/data-1572M.xml";
            start = System.currentTimeMillis();
            parseFile(fileName);
            System.out.println((System.currentTimeMillis() - start) + "ms");
        }

        private static void parseFile(String fileName) throws Exception
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File(fileName), handler);
            handler.printResults();
        }

       /* Буферизация SELECT запросов

       StringBuilder builder = new StringBuilder();
        for(int i = 1920; i < 2015; i++)
        {
            if (builder.length() > 0)
            {
                builder.append(',');
            }
            builder.append("'");
            builder.append(i);
            builder.append("-10-10'");
        }
        String sql = "SELECT * FROM voter_count WHERE birthDate IN(" + builder.toString() + ")";
        System.out.println(sql); */


    }
