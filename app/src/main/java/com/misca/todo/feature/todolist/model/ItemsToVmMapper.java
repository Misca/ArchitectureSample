package com.misca.todo.feature.todolist.model;

import com.misca.data.ResultMapper;
import com.misca.data.feature.todo.local.ToDoItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mihaimecea on 20.March.2019
 */
public class ItemsToVmMapper implements ResultMapper<List<ToDoItemModel>, List<ToDoItemViewModel>> {

    @Override
    public List<ToDoItemViewModel> map(List<ToDoItemModel> dataItems) {
        List<ToDoItemViewModel> vmItems = new ArrayList<>();

        for (ToDoItemModel dataItem : dataItems) {
            ToDoItemViewModel viewModelItem = new ToDoItemViewModel();
            viewModelItem.isChecked.set(dataItem.isChecked);
            viewModelItem.taskName.set(dataItem.taskName);

            vmItems.add(viewModelItem);
        }

        return vmItems;
    }

}
