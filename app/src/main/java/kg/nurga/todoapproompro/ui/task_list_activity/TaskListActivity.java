package kg.nurga.todoapproompro.ui.task_list_activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kg.nurga.todoapproompro.R;
import kg.nurga.todoapproompro.room.Task;
import kg.nurga.todoapproompro.ui.add_task_activity.AddTaskActivity;

public class TaskListActivity extends AppCompatActivity implements TaskListContract.View {

    private TaskListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new TaskListPresenter(this);

        initView();
    }

    public void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchAddTaskActivity();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getTasks();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_delete_all) {
            presenter.deleteAllTasks();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void showTasks(final LiveData<List<Task>> tasks) {
//        RecyclerView recyclerView = findViewById(R.id.recycler_taskList);
//        RecyclerTaskListAdapter adapter = new RecyclerTaskListAdapter();
//        adapter.setItems(tasks);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setAdapter(adapter);
//
//        adapter.setClickListener(new RecyclerTaskListAdapter.ClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                final Task task = tasks.get(position);
//                launchEditTaskActivity(task);
//            }
//        });
//    }

    @Override
    public void showText(String text) {
        Snackbar.make(findViewById(R.id.fab), text, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void launchAddTaskActivity() {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }

    @Override
    public void launchEditTaskActivity(Task task) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        intent.putExtra("TASK_MODEL", (Serializable) task);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
