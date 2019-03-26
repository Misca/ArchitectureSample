package com.misca.todo.feature.todolist.model.mapper;

import com.misca.data.feature.todo.local.ToDoEntity;
import com.misca.todo.feature.todolist.model.ToDoItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * Created by mihaimecea on 20.March.2019
 */
public class ItemsToVmMapper implements Function<List<ToDoEntity>, List<ToDoItemViewModel>> {


    @Override
    public List<ToDoItemViewModel> apply(List<ToDoEntity> dataItems) {
        List<ToDoItemViewModel> vmItems = new ArrayList<>();

        for (ToDoEntity dataItem : dataItems) {
            ToDoItemViewModel viewModelItem = new ToDoItemViewModel();
            viewModelItem.isChecked.set(dataItem.isChecked);
            viewModelItem.taskName.set(dataItem.taskName);

            vmItems.add(viewModelItem);
        }

        return vmItems;
    }
}
