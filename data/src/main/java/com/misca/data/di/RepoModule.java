package com.misca.data.di;

import android.app.Application;
import android.content.Context;

import com.misca.data.ToDoRepository;
import com.misca.data.feature.todo.ToDoRepositoryImpl;
import com.misca.data.feature.todo.local.ToDoLocalDataStore;
import com.misca.data.store.local.ToDoDatabase;

import androidx.room.Room;

public class RepoModule {

    private Context context;

    private volatile ToDoDatabase database;

    public RepoModule(Application application) {
        this.context = application.getApplicationContext();
    }

    public ToDoRepository provideToDoRepository() {
        return new ToDoRepositoryImpl(provideLocalDataStore());
    }

    ToDoLocalDataStore provideLocalDataStore() {
        ToDoDatabase database = getInstance();
        return new ToDoLocalDataStore(database.toDoDao());
    }

    ToDoDatabase getInstance() {
        if (database == null) {
            synchronized (ToDoDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            ToDoDatabase.class, "Sample.db")
                            .build();
                }
            }
        }
        return database;
    }
}
