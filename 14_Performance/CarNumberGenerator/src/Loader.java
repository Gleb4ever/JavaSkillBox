import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Loader {

    private static final int THREAD_AMOUNT = 15;
    private static final int REGION_AMOUNT = 100;

    public static void main(String[] args) {

    if(THREAD_AMOUNT > 0 && REGION_AMOUNT >0){
        long start = System.currentTimeMillis();
        int finishRegionCode = 0;
        int startRegionCode = 1;
        int z = REGION_AMOUNT - REGION_AMOUNT % THREAD_AMOUNT;
        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_AMOUNT);
        for (int i = 0; i < THREAD_AMOUNT; i++) {
            finishRegionCode = z - ((z - finishRegionCode) - z / THREAD_AMOUNT);
            pool.submit(new FileWriterThread(startRegionCode, finishRegionCode, letters, i, start));
            System.out.println(new StringBuilder("Поток#").append(i).append(" запущен. Записывает регион от ")
                    .append(startRegionCode).append(" до ").append(finishRegionCode).toString());
            startRegionCode = finishRegionCode;
        }
        if (z != REGION_AMOUNT) {
            pool.submit(new FileWriterThread(z, REGION_AMOUNT, letters, THREAD_AMOUNT, start));
            System.out.println(new StringBuilder("Поток#").append(THREAD_AMOUNT).append(" запущен. Записывает регион от ")
                    .append(z).append(" до ").append(REGION_AMOUNT).toString());
        }
        pool.shutdown();
    } else
        { System.out.println("Некорректное значение рабочего параметра. Работа прекращена!");
    }
    }
}
