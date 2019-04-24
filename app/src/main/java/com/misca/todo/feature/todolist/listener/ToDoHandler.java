package com.misca.todo.feature.todolist.listener;

import com.misca.todo.feature.todolist.model.ToDoItemViewModel;

/**
 * Created by mihaimecea on 22.April.2019
 */
public interface ToDoHandler {

    void onItemSelected(ToDoItemViewModel item);

    void onDeleteItemSelected(ToDoItemViewModel item);

}
