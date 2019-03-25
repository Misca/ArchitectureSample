package com.misca.data;

import com.misca.data.feature.todo.local.ToDoItemModel;

import java.util.List;

public interface ToDoRepository {

    List<ToDoItemModel> getToDos();

    void saveToDos(List<ToDoItemModel> toDos);
}
