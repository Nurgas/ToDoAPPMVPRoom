package kg.nurga.todoapproompro.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "task_table")

public class Task {

@PrimaryKey(autoGenerate = true)
    private int id;
@NonNull
@ColumnInfo(name ="title")
    private String title;
@NonNull
@ColumnInfo(name = "description")

    private String description;

    public Task(@NonNull String title, @NonNull String description) {
        this.title = title;
        this.description = description;
    }
@Ignore
    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
}
