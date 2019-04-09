package kg.nurga.todoapproompro.ui.add_task_activity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import kg.nurga.todoapproompro.R;
import kg.nurga.todoapproompro.room.Task;

public class AddTaskActivity extends AppCompatActivity implements AddTaskContract.View {

    private AddTaskContract.Presenter presenter;
    private EditText editText_title;
    private EditText editText_description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        presenter = new AddTaskPresenter(this);

        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar_add);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);

        editText_title = findViewById(R.id.editText_title);
        editText_description = findViewById(R.id.editText_description);

        FloatingActionButton fab = findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task();
                task.setTitle(editText_title.getText().toString());
                task.setDescription(editText_description.getText().toString());

                presenter.clickSave(task);
            }
        });

        Task task = (Task) getIntent().getSerializableExtra("TASK_MODEL");
        presenter.setTask(task);
    }

    @Override
    public void setToolbarTitle(String title) {

        getSupportActionBar().setTitle(title);
    }

    @Override
    public void fillTheFields(Task task) {
        editText_title.setText(task.getTitle());
        editText_description.setText(task.getDescription());
    }


    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void closeView() {
        presenter.detachView();
        finish();
    }
}
