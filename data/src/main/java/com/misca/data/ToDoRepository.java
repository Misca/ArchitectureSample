package com.misca.data;

import com.misca.data.feature.todo.local.ToDoEntity;

import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface ToDoRepository {

    @NonNull
    Flowable<List<ToDoEntity>> getToDoList();

    @NonNull
    Single<ToDoEntity> getToDoItem(int itemId);

    @NonNull
    Completable saveToDoItem(ToDoEntity toDos);

    @NonNull
    Completable deleteItem(int itemId);
}
