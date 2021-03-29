import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriterThread extends Thread{

    private static final String FILE_PATH_TEMPLATE = "res/";

    private static final String FILE_EXT = ".txt";

    private final StringBuilder sb = new StringBuilder();

    private final int startRegionCode;

    private final int finishRegionCode;

    private final char[] numLetters;

    private final int threadNum;

    private final long start;

    public FileWriterThread(int startRegionCode, int finishRegionCode, char[] numLetters, int threadNum, long start)
    {
        this.startRegionCode = startRegionCode;
        this.finishRegionCode = finishRegionCode;
        this.numLetters = numLetters;
        this.threadNum = threadNum;
        this.start = start;
    }

    private static String padNumber(int number, int numberLength)
    {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();
        for(int i = 0; i < padSize; i++) {
            numberStr.insert(0, '0');
        }
        return numberStr.toString();
    }

    @Override
    public void run()
    {
        try {
            File resultFile = new File(createFilePath());
            PrintWriter printWriter = new PrintWriter(resultFile);
            for (int regionCode = startRegionCode; regionCode < finishRegionCode; regionCode++) {
                StringBuilder builder = new StringBuilder();
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : numLetters) {
                        for (char secondLetter : numLetters) {
                            for (char thirdLetter : numLetters) {
                                builder.append(firstLetter);
                                builder.append(padNumber(number, 3));
                                builder.append(secondLetter);
                                builder.append(thirdLetter);
                                builder.append(padNumber(regionCode, 2));
                                builder.append("\n");
                            }
                        }
                    }
                }
                printWriter.write(builder.toString());
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        printResult();
    }

    private void printResult()
    {
        sb.append(": ");
        sb.append(System.currentTimeMillis() - start);
        sb.append("ms.");
        System.out.println(sb.toString());
    }

    private String createFilePath()
    {
        sb.append(FILE_PATH_TEMPLATE);
        sb.append("Thread#");
        sb.append(this.threadNum);
        sb.append("_Regions_");
        sb.append(this.startRegionCode);
        sb.append("-");
        sb.append(this.finishRegionCode);
        sb.append(FILE_EXT);
        return sb.toString();
    }

}
