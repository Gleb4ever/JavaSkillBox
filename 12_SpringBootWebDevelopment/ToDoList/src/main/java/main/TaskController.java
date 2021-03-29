package main;
import main.model.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController
{
    private final Storage storage;

    @Autowired
    private TaskRepository taskRepository;

    public TaskController(Storage storage)
    {
        this.storage = storage;
    }

    @GetMapping("/tasks/")
    public List<Task> list()
    {
       Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for(Task task : taskIterable){
            tasks.add(task);
        }
        return tasks;
    }

    @PostMapping("/tasks/")
    public int add(Task task)
    {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity get(@PathVariable int id)
    {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(!optionalTask.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalTask.get(),HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity delete(@PathVariable int id)
    {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()){
            taskRepository.delete(optionalTask.get());
            return new ResponseEntity(optionalTask.get(),HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/task/{id}")
    public ResponseEntity post(@PathVariable int id, @RequestBody Task task)
    {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()){
            BeanUtils.copyProperties(task,optionalTask);
            taskRepository.save(optionalTask.get());
            return new ResponseEntity(optionalTask.get(),HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
