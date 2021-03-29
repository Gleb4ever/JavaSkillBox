import org.redisson.Redisson;
import org.redisson.api.RDeque;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

public class RedisSetting {

    private RedissonClient redissonClient;

    public static final int USERS_AMOUNT = 20;

    private RDeque<Integer> registeredUsersIds;

    void init()
    {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redissonClient = Redisson.create(config);
        } catch (RedisConnectionException Exc){
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(Exc.getMessage());
        }
        registeredUsersIds = redissonClient.getDeque("users");
    }

    public void initData()
    {
        for(int i = 0; i < USERS_AMOUNT; i++){
            registeredUsersIds.add(i);
        }
    }

    public void addLast(int userId)
    {
        registeredUsersIds.addLast(userId);
    }

    public void pusher(int userId)
    {
        registeredUsersIds.push(userId);
    }

    public Integer peekFirstUser()
    {
        return registeredUsersIds.peekFirst();
    }

    public Integer removeFirstUser()
    {
        return registeredUsersIds.removeFirst();
    }
}
