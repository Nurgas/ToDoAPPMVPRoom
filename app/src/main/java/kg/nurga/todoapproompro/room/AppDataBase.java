package kg.nurga.todoapproompro.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kg.nurga.todoapproompro.App;

@Database(entities ={Task.class},version = 1, exportSchema = false)

public abstract class AppDataBase extends RoomDatabase {

    public abstract TaskDao mTaskDao();

    private static AppDataBase INSTANCE;

    public static AppDataBase getDataBase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDataBase.class) {
                INSTANCE = Room.databaseBuilder(App.getAppContext()
                        ,AppDataBase.class, "task_database").build();
            }
        }

        return INSTANCE;
    }


}

