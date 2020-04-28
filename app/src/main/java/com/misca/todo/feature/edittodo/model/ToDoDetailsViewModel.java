package com.misca.todo.feature.edittodo.model;

import android.annotation.SuppressLint;
import android.util.Log;

import com.misca.data.ToDoRepository;
import com.misca.todo.R;
import com.misca.todo.feature.todolist.model.ToDoPriority;
import com.misca.todo.feature.edittodo.mapper.EntityToDetailsVMMapper;
import com.misca.todo.feature.edittodo.mapper.ItemDetailToDataMapper;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class ToDoDetailsViewModel extends ViewModel implements LifecycleObserver {

    private static final String TAG = ToDoDetailsViewModel.class.getName();

    private ToDoRepository repository;

    @Nullable
    public Integer todoItemId;
    public final ObservableField<String> taskName;
    public ToDoPriority priority;
    public final ObservableInt priorityColor;

    public ToDoDetailsViewModel(ToDoRepository repository) {
        this.repository = repository;
        this.taskName = new ObservableField<>("");
        this.priorityColor = new ObservableInt(R.color.colorPriority3);
        this.priority = ToDoPriority.LEVEL_THREE;
    }

    @SuppressLint("CheckResult")
    public void initToDoItem(int itemId) {
        Log.d(TAG, "initToDoItem()");

        if (taskName.get().isEmpty()) {
            this.todoItemId = itemId;

            repository.getToDoItem(todoItemId)
                      .map(new EntityToDetailsVMMapper(this))
                      .subscribe(
                              toDoEntity -> Log.d(TAG, "initToDoItem: onSuccess : " + toDoEntity.taskName),
                              throwable -> Log.e(TAG, "fetchToDoList error: ", throwable)
                      );
        }
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void saveToDoItem() {
        Log.d(TAG, "saveToDoItem()");
        repository
                .saveToDoItem(new ItemDetailToDataMapper().apply(this))
                .subscribe(
                        () -> Log.d(TAG, "saveToDoItem : saved"),
                        throwable -> Log.d(TAG, "saveToDoItem : onError" + throwable)
                );
    }

    public void onPrioritySelected(ToDoPriority level) {
        //TODO 3: check how this method is called from layout
        // - add the missing colors for ONE, TWO and THREE priority
        // - test it out

        this.priority = level;
        switch (level) {
            case LEVEL_ZERO:
                priorityColor.set(R.color.colorPriority0);
                break;
            case LEVEL_ONE:

                break;
            case LEVEL_TWO:

                break;
            case LEVEL_THREE:

                break;
        }
    }

}
