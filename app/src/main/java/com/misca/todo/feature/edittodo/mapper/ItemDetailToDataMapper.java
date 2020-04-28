package com.misca.todo.feature.edittodo.mapper;

import com.misca.data.feature.todo.local.ToDoEntity;
import com.misca.todo.feature.edittodo.model.ToDoDetailsViewModel;

import io.reactivex.functions.Function;

public class ItemDetailToDataMapper implements Function<ToDoDetailsViewModel, ToDoEntity> {

    @Override
    public ToDoEntity apply(ToDoDetailsViewModel vmItems) {
        ToDoEntity entity = new ToDoEntity();

        entity.taskName = vmItems.taskName.get();
        entity.id = vmItems.todoItemId;

        switch (vmItems.priority) {
            case LEVEL_ZERO:
                entity.priority = 0;
                break;
            case LEVEL_ONE:
                entity.priority = 1;
                break;
            case LEVEL_TWO:
                entity.priority = 2;
                break;
            case LEVEL_THREE:
                entity.priority = 3;
                break;
        }

        return entity;
    }
}
