package com.misca.todo.feature.todolist.model;

import android.util.Log;

import com.misca.data.ToDoRepository;
import com.misca.data.feature.todo.local.ToDoItemModel;

import java.util.List;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class ToDoViewModel extends ViewModel implements LifecycleObserver {

    private static final String TAG = ToDoViewModel.class.getName();

    //for the next course
    private ToDoRepository repository;

    public ObservableList<ToDoItemViewModel> items;

    public ToDoViewModel(ToDoRepository repository) {
        this.repository = repository;

        this.items = new ObservableArrayList<>();
    }

    public void onAddTaskClick() {
        Log.d("ToDoViewModel", "onAddTaskClick");
        items.add(new ToDoItemViewModel());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void fetchToDoList() {
        Log.d(TAG, "fetchToDoList()");

        if(items.isEmpty()) {
            List<ToDoItemModel> dataItems = repository.getToDos();
            List<ToDoItemViewModel> vmItems = new ItemsToVmMapper().map(dataItems);

            items.addAll(vmItems);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void saveToDoList() {
        Log.d(TAG, "saveToDoList()");
    }

}
