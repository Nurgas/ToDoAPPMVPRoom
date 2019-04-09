package kg.nurga.todoapproompro.ui.add_task_activity;


import kg.nurga.todoapproompro.room.Task;

public interface AddTaskContract {

    interface View {
        void setToolbarTitle(String title);

        void fillTheFields(Task task);

        void showToast(String text);

        void closeView();
    }

    interface Presenter {
        void setTask(Task task);

        void clickSave(Task task);

        void detachView();
    }
}
