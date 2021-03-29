package main;
import main.model.Task;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Storage
{
    public AtomicInteger currentId;

    public ConcurrentHashMap <Integer,Task> tasks = new ConcurrentHashMap<Integer, Task>();

    public List<Task> getAllTasks()
    {
        ArrayList<Task> tasksList = new ArrayList<Task>();
        tasksList.addAll(tasks.values());
        return tasksList;
    }

    public int addTask(Task task)
    {
        int id = currentId.addAndGet(1);
        task.setId(id);
        tasks.put(id,task);
        return id;
    }

    public Task getTask(int taskId)
    {
        if(tasks.containsKey(taskId)) {
            return tasks.get(taskId);
        }
        return null;
    }

    public Task deleteTask(int taskId)
    {
        if(tasks.containsKey(taskId)){
            return tasks.remove(taskId);
        }
        return null;
    }

    public Task updateTask(int taskId, Task task)
    {
        if(tasks.containsKey(taskId)){
            return tasks.replace(taskId, task);
        }
        return null;
    }
}

