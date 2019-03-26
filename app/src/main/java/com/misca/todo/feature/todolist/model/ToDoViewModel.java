package com.misca.todo.feature.todolist.model;

import android.util.Log;

import com.misca.data.ToDoRepository;
import com.misca.todo.feature.todolist.model.mapper.ItemsToDataMapper;
import com.misca.todo.feature.todolist.model.mapper.ItemsToVmMapper;

import java.util.List;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class ToDoViewModel extends ViewModel implements LifecycleObserver {

    private static final String TAG = ToDoViewModel.class.getName();

    private ToDoRepository repository;
    private Disposable disposable;

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
            repository.getToDoList()
                    .map(new ItemsToVmMapper())
                    .subscribe(new SingleObserver<List<ToDoItemViewModel>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            disposable = d;
                        }

                        @Override
                        public void onSuccess(List<ToDoItemViewModel> toDoItems) {
                            onToDoListReceived(toDoItems);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void saveToDoList() {
        Log.d(TAG, "saveToDoList()");

        repository.saveToDos(new ItemsToDataMapper().apply(items));
    }

    private void onToDoListReceived(List<ToDoItemViewModel> toDoItems) {
        items.clear();
        items.addAll(toDoItems);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(disposable != null) {
            disposable.dispose();
        }
    }
}
