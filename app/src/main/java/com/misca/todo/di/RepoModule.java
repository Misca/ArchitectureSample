package com.misca.todo.di;

import android.app.Application;
import android.content.Context;

import com.misca.data.ToDoRepository;
import com.misca.data.feature.todo.ToDoRepositoryImpl;

/**
 * Created by mihaimecea on 20.March.2019
 */
public class RepoModule {


    private Context context;
    private ToDoRepository toDoRepository;

    public RepoModule(Application application) {
        this.context = application.getApplicationContext();
    }

    public Context provideAppContext() {
        return context;
    }

    public ToDoRepository provideToDoRepository() {
        if(toDoRepository == null) {
            toDoRepository = newToDoRepositoryInstance();
        }

        return toDoRepository;
    }

    private synchronized ToDoRepository newToDoRepositoryInstance() {
        return new ToDoRepositoryImpl(context);
    }
}
