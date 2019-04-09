package kg.nurga.todoapproompro.repository;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import kg.nurga.todoapproompro.App;
import kg.nurga.todoapproompro.room.AppDataBase;
import kg.nurga.todoapproompro.room.Task;
import kg.nurga.todoapproompro.room.TaskDao;

public class TasksRepositoryImpl implements TasksRepository {

    private TaskDao mTaskDao;

    private LiveData<List<Task>> allTasks;

    public TasksRepositoryImpl() {
        AppDataBase db =  AppDataBase.getDataBase(App.getAppContext());
        mTaskDao = db.mTaskDao();
        allTasks = mTaskDao.getAllTasks();
    }


    @Override
    public LiveData<List<Task>> getAllTasks() {

        return allTasks;
    }

    @Override
    public void addTask(Task task) {

        new insertAsyncTask(mTaskDao).execute(task);
    }

    @Override
    public void editTask(Task task) {

    }

    @Override
    public void deleteAllTasks() {

    }


    private static class insertAsyncTask extends AsyncTask<Task, Void , Void> {

        private TaskDao mTaskDao;

        public insertAsyncTask(TaskDao taskDao) {
            mTaskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... task) {
            mTaskDao.insert(task[0]);
            return null;
        }
    }
}
