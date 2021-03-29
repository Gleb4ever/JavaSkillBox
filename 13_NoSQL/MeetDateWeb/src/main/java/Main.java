import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Main {

    private static final int SLEEP = 2000;

    private static final Random RANDOM = new Random();

    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");

    private static void log (int UsersOnline)
    {
        String log = String.format("[%s] Пользователей онлайн: %d", DF.format(new Date()), UsersOnline);
        System.out.println(log);
    }

    public static void main(String[] args) throws InterruptedException
    {
        RedisSetting redis = new RedisSetting();
        redis.init();
        redis.initData();

        while (true)
        {
            for (int i = 1; i<= RedisSetting.USERS_AMOUNT; i++){
                System.out.println("На главной странице показываем пользователя " + redis.peekFirstUser());
                redis.addLast(redis.removeFirstUser());
                if(i % getRandom() == 0){
                    System.out.println("Пользователь " + i + " оплатил платную услугу");
                    redis.pusher(i);
                    log(i);
                }
            }
            System.out.println("===");
            Thread.sleep(SLEEP);
        }
    }

    public static int getRandom()
    {
        return RANDOM.nextInt(RedisSetting.USERS_AMOUNT) + 1;
    }
}

