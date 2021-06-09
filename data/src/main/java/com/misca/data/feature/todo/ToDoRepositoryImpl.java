package com.misca.data.feature.todo;

import com.misca.data.ToDoRepository;
import com.misca.data.feature.todo.local.ToDoEntity;
import com.misca.data.feature.todo.local.ToDoLocalDataStore;

import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class ToDoRepositoryImpl implements ToDoRepository {

    private static final String TAG = ToDoRepositoryImpl.class.getName();

    private final ToDoLocalDataStore localDataStore;

    public ToDoRepositoryImpl(ToDoLocalDataStore localDataStore) {
        this.localDataStore = localDataStore;
    }

    @NonNull
    @Override
    public Flowable<List<ToDoEntity>> getToDoList() {
        return localDataStore.getToDoList()
                .subscribeOn(Schedulers.io());
    }

    @NonNull
    @Override
    public Completable saveToDoItem(ToDoEntity toDo) {
        return localDataStore.saveItem(toDo)
                .subscribeOn(Schedulers.io());
    }

    @NonNull
    @Override
    public Completable deleteItem(int itemId) {
        return localDataStore.deleteToDoItem(itemId)
                .subscribeOn(Schedulers.io());
    }

    @NonNull
    @Override
    public Single<ToDoEntity> getToDoItem(int itemId) {
        return localDataStore.getToDoItem(itemId)
                .subscribeOn(Schedulers.io());
    }
}
