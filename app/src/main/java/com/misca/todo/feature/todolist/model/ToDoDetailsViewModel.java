package com.misca.todo.feature.todolist.model;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.misca.data.ToDoRepository;
import com.misca.data.feature.todo.local.ToDoEntity;
import com.misca.todo.R;
import com.misca.todo.feature.todolist.model.mapper.ItemDetailToDataMapper;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class ToDoDetailsViewModel extends ViewModel implements LifecycleObserver {

    private static final String TAG = ToDoDetailsViewModel.class.getName();

    private ToDoRepository repository;
    private Disposable disposable;

    @Nullable
    public Integer todoItemId;
    public final ObservableField<String> taskName;
    @ToDoPriority
    public int priority;
    public final ObservableInt priorityColor;

    public ToDoDetailsViewModel(ToDoRepository repository) {
        this.repository = repository;
        this.taskName = new ObservableField<>("");
        this.priorityColor = new ObservableInt(R.color.colorPriority3);
        this.priority = ToDoPriority.LEVEL_THREE;
    }

    public void initToDoItem(int itemId) {
        Log.d(TAG, "initToDoItem()");

        if(taskName.get().isEmpty()) {
            this.todoItemId = itemId;

            repository.getToDoItem(todoItemId)
                    .subscribe(new SingleObserver<ToDoEntity>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            disposable = d;
                        }

                        @Override
                        public void onSuccess(ToDoEntity dataItem) {
                            Log.d(TAG, "initToDoItem: onSuccess : " + dataItem.taskName);
                            taskName.set(dataItem.taskName);
                            onPrioritySelected(dataItem.priority);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "fetchToDoList error: ", e);
                        }
                    });
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

    public void onPrioritySelected(@ToDoPriority int level) {
        //TODO 3: check how this method is called from layout
        // - add the missing colors for ONE, TWO and THREE priority
        // - test it out

        this.priority = level;
        switch (level) {
            case ToDoPriority.LEVEL_ZERO:
                priorityColor.set(R.color.colorPriority0);
                break;
            case ToDoPriority.LEVEL_ONE:

                break;
            case ToDoPriority.LEVEL_TWO:

                break;
            case ToDoPriority.LEVEL_THREE:

                break;
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(disposable != null) {
            disposable.dispose();
        }
    }

}
