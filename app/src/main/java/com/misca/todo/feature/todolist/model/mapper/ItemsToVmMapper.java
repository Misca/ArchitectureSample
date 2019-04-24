package com.misca.todo.feature.todolist.model.mapper;

import com.misca.data.feature.todo.local.ToDoEntity;
import com.misca.todo.R;
import com.misca.todo.feature.todolist.model.ToDoItemViewModel;
import com.misca.todo.feature.todolist.model.ToDoPriority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * Created by mihaimecea on 20.March.2019
 */
public class ItemsToVmMapper implements Function<List<ToDoEntity>, List<ToDoItemViewModel>> {


    @Override
    public List<ToDoItemViewModel> apply(List<ToDoEntity> dataItems) {
        List<ToDoItemViewModel> vmItems = new ArrayList<>();

        Collections.sort(dataItems, new Comparator<ToDoEntity>() {
            @Override
            public int compare(ToDoEntity o1, ToDoEntity o2) {
                return o1.priority - o2.priority;
            }
        });

        for (ToDoEntity dataItem : dataItems) {
            ToDoItemViewModel viewModelItem = new ToDoItemViewModel();

            viewModelItem.isChecked.set(dataItem.isChecked);
            viewModelItem.taskName.set(dataItem.taskName);
            viewModelItem.id = dataItem.id;

            switch (dataItem.priority) {
                case ToDoPriority.LEVEL_ZERO:
                    viewModelItem.priorityColor = R.color.colorPriority0;
                    break;
                case ToDoPriority.LEVEL_ONE:
                    viewModelItem.priorityColor = R.color.colorPriority1;
                    break;
                case ToDoPriority.LEVEL_TWO:
                    viewModelItem.priorityColor = R.color.colorPriority2;
                    break;
                case ToDoPriority.LEVEL_THREE:
                    viewModelItem.priorityColor = R.color.colorPriority3;
                    break;
            }

            vmItems.add(viewModelItem);
        }

        return vmItems;
    }
}
