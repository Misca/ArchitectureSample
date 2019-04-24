package com.misca.todo.feature.todolist.model.mapper;

import com.misca.data.feature.todo.local.ToDoEntity;
import com.misca.todo.feature.todolist.model.ToDoDetailsViewModel;
import com.misca.todo.feature.todolist.model.ToDoItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ItemDetailToDataMapper implements Function<ToDoDetailsViewModel, ToDoEntity> {

    @Override
    public ToDoEntity apply(ToDoDetailsViewModel vmItems) {
        ToDoEntity entity = new ToDoEntity();

        entity.taskName = vmItems.taskName.get();
        entity.id = vmItems.todoItemId;
        entity.priority = vmItems.priority;

        return entity;
    }
}
