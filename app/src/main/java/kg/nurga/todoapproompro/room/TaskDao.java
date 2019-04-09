package kg.nurga.todoapproompro.room;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    void insert(Task task);

    @Query("DELETE FROM TASK_TABLE")

    void deleteAll();

    @Query("SELECT * from TASK_TABLE ORDER BY title")
    LiveData<List<Task>> getAllTasks();

    @Delete

    void deleteTask(Task task);

    @Update(onConflict = OnConflictStrategy.REPLACE)

    void ubdate(Task task);
}
