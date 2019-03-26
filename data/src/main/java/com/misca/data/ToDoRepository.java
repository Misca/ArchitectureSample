package com.misca.data;

import com.misca.data.feature.todo.local.ToDoEntity;

import java.util.List;

import io.reactivex.Single;

public interface ToDoRepository {

    Single<List<ToDoEntity>> getToDoList();

    void saveToDos(List<ToDoEntity> toDos);
}
