package com.misca.todo.feature.todolist.model.mapper;

import com.misca.data.feature.todo.local.ToDoEntity;
import com.misca.todo.feature.todolist.model.ToDoItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ItemsToDataMapper implements Function<List<ToDoItemViewModel>, List<ToDoEntity>> {

    @Override
    public List<ToDoEntity> apply(List<ToDoItemViewModel> dataItems) {
        List<ToDoEntity> toDoEntities = new ArrayList<>();

        for (ToDoItemViewModel vmItem : dataItems) {
            ToDoEntity entity = new ToDoEntity();
            entity.isChecked = vmItem.isChecked.get();
            entity.taskName = vmItem.taskName.get();

            toDoEntities.add(entity);
        }

        return toDoEntities;
    }
}
