package kg.nurga.todoapproompro.repository;


import java.util.List;

import androidx.lifecycle.LiveData;
import kg.nurga.todoapproompro.room.Task;

public interface TasksRepository {

    LiveData<List<Task>> getAllTasks();

    void deleteAllTasks();

    void addTask(Task task);

    void editTask(Task task);
}
