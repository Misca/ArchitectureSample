package com.misca.todo.feature.edittodo.mapper;

import com.misca.data.feature.todo.local.ToDoEntity;
import com.misca.todo.feature.edittodo.model.ToDoDetailsViewModel;

import io.reactivex.functions.Function;

import static com.misca.todo.feature.todolist.model.ToDoPriority.LEVEL_ONE;
import static com.misca.todo.feature.todolist.model.ToDoPriority.LEVEL_THREE;
import static com.misca.todo.feature.todolist.model.ToDoPriority.LEVEL_TWO;
import static com.misca.todo.feature.todolist.model.ToDoPriority.LEVEL_ZERO;

/**
 * Created by mihai.mecea on 28.April.2020
 */
public class EntityToDetailsVMMapper implements Function<ToDoEntity, ToDoEntity> {
    private final ToDoDetailsViewModel toDoDetailsViewModel;

    public EntityToDetailsVMMapper(ToDoDetailsViewModel toDoDetailsViewModel) {
        this.toDoDetailsViewModel = toDoDetailsViewModel;
    }

    @Override
    public ToDoEntity apply(ToDoEntity toDoEntity) {
        toDoDetailsViewModel.taskName.set(toDoEntity.taskName);
        switch (toDoEntity.priority) {
            case 0:
                toDoDetailsViewModel.onPrioritySelected(LEVEL_ZERO);
                break;
            case 1:
                toDoDetailsViewModel.onPrioritySelected(LEVEL_ONE);
                break;
            case 2:
                toDoDetailsViewModel.onPrioritySelected(LEVEL_TWO);
                break;
            case 3:
                toDoDetailsViewModel.onPrioritySelected(LEVEL_THREE);
                break;
        }
        return toDoEntity;
    }
}
