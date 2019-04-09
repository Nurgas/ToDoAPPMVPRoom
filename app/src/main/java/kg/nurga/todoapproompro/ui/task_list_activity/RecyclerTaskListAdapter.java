package kg.nurga.todoapproompro.ui.task_list_activity;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import kg.nurga.todoapproompro.R;
import kg.nurga.todoapproompro.room.Task;

public class RecyclerTaskListAdapter extends RecyclerView.Adapter<RecyclerTaskListAdapter.ViewHolder> {

    private List<Task> task;
    private static ClickListener clickListener;

    public RecyclerTaskListAdapter() {

        task = new ArrayList<>();
    }

    public void setItems(List<Task> tasks) {
        this.task = tasks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_task, viewGroup, false);
        return new RecyclerTaskListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Task task = this.task.get(position);

        viewHolder.title.setText(task.getTitle());
        viewHolder.description.setText(task.getDescription());
    }

    @Override
    public int getItemCount() {

        return task.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView_title);
            description = itemView.findViewById(R.id.textView_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(view, ViewHolder.this.getAdapterPosition());
                }
            });
        }
    }

    public void setClickListener(ClickListener clickListener) {
        RecyclerTaskListAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(View v, int position);
    }
}
