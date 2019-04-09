package kg.nurga.todoapproompro.ui.task_list_activity;


import java.util.List;

import androidx.lifecycle.LiveData;
import kg.nurga.todoapproompro.room.Task;

public interface TaskListContract {

    interface View {

        void showText(String text);

        void launchAddTaskActivity();

        void launchEditTaskActivity(Task tasks);
//
//        void showTasks(LiveData<List<Task>> tasks);
    }

    interface Presenter {
        void getTasks();

        void deleteAllTasks();

        void detachView();
    }
}
