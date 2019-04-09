package kg.nurga.todoapproompro.ui.add_task_activity;


import androidx.annotation.NonNull;
import kg.nurga.todoapproompro.repository.RepositoryProvider;
import kg.nurga.todoapproompro.room.Task;

public class AddTaskPresenter implements AddTaskContract.Presenter {

    private AddTaskContract.View view;
    private Task TASK_MODEL;
    private boolean isNewTask;

    public AddTaskPresenter(AddTaskContract.View view) {
        this.view = view;
    }

    @Override
    public void setTask(Task task) {
        this.TASK_MODEL = task;
        if (TASK_MODEL != null) {
            isNewTask = false;
            view.setToolbarTitle("Edit Task");
            view.fillTheFields(TASK_MODEL);
        } else {
            isNewTask = true;
            view.setToolbarTitle("Add new Task");
        }
    }

    @Override
    public void clickSave(Task task) {
        if (checkTask(task)) {
            if (isNewTask)
                RepositoryProvider
                        .provideTasksRepository()
                        .addTask(task);
            else
                RepositoryProvider
                        .provideTasksRepository().editTask(task);

            closeView();

        } else
            view.showToast("Please, fill all the fields");
    }

    @Override
    public void detachView() {

        view = null;
    }

    public void closeView() {
        if (isNewTask) {
            view.showToast("New Task has been saved");
            view.closeView();
        } else {
            view.showToast("Task changes has been saved");
            view.closeView();
        }
    }

    public boolean checkTask(@NonNull Task task) {
        if (task.getTitle().isEmpty())
            return false;

        if (task.getDescription().isEmpty())
            return false;

        return true;
    }

}