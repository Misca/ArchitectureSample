package com.misca.data.feature.todo;

import android.content.Context;

import com.misca.data.ToDoRepository;
import com.misca.data.feature.todo.local.ToDoItemModel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


public class ToDoRepositoryImpl implements ToDoRepository {

    public ToDoRepositoryImpl(Context context) {
        //mock repo
    }

    @Override
    public List<ToDoItemModel> getToDos() {
        //Mock implementation
        List<ToDoItemModel> items = new ArrayList<>();
        ToDoItemModel item = new ToDoItemModel();
        item.isChecked = false;
        item.taskName = "Some task";
        items.add(item);

        item = new ToDoItemModel();
        item.isChecked = false;
        item.taskName = "Some other task";
        items.add(item);

        return items;
    }

    @Override
    public void saveToDos(List<ToDoItemModel> toDos) {

    }

}
