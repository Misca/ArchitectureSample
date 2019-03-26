package com.misca.data.feature.todo;

import com.misca.data.ToDoRepository;
import com.misca.data.feature.todo.local.ToDoEntity;
import com.misca.data.feature.todo.local.ToDoLocalDataStore;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ToDoRepositoryImpl implements ToDoRepository {

    private ToDoLocalDataStore localDataStore;

    public ToDoRepositoryImpl(ToDoLocalDataStore localDataStore) {
        this.localDataStore = localDataStore;
    }

    @Override
    public Single<List<ToDoEntity>> getToDoList() {
        return localDataStore.getToDoList()
                .subscribeOn(Schedulers.io());
    }

    @Override
    public void saveToDos(List<ToDoEntity> toDoList) {
        localDataStore.saveToDos(toDoList)
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

}
