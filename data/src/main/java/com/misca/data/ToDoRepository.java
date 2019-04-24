package com.misca.data;

import com.misca.data.feature.todo.local.ToDoEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface ToDoRepository {

    Flowable<List<ToDoEntity>> getToDoList();

    Single<ToDoEntity> getToDoItem(int itemId);

    Completable saveToDoItem(ToDoEntity toDos);

    Completable deleteItem(int itemId);
}
