package kg.nurga.todoapproompro.ui.task_list_activity;

import java.util.List;

import androidx.lifecycle.LiveData;
import kg.nurga.todoapproompro.repository.RepositoryProvider;
import kg.nurga.todoapproompro.room.Task;

public class TaskListPresenter implements TaskListContract.Presenter {

    private TaskListContract.View view;

    public TaskListPresenter(TaskListContract.View view) {

        this.view = view;
    }

    @Override
    public void getTasks() {

        LiveData<List<Task>> tasks = RepositoryProvider.provideTasksRepository().getAllTasks();

//    view.showTasks(tasks);
    }

    @Override
    public void deleteAllTasks() {
        RepositoryProvider
                .provideTasksRepository()
                .deleteAllTasks();

        getTasks();
        view.showText("All tasks has been deleted");
    }

    @Override
    public void detachView() {
        view = null;
    }
}
