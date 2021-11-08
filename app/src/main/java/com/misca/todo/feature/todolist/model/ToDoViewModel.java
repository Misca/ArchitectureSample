package com.misca.todo.feature.todolist.model;

import android.annotation.SuppressLint;
import android.util.Log;

import com.misca.data.ToDoRepository;
import com.misca.todo.feature.todolist.listener.ToDoHandler;
import com.misca.todo.feature.todolist.model.mapper.ItemsToVmMapper;

import java.util.List;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class ToDoViewModel extends ViewModel implements LifecycleObserver, ToDoHandler {

    private static final String TAG = ToDoViewModel.class.getName();

    private final ToDoRepository repository;
    private Disposable disposable;

    public final PublishSubject<ToDoEventModel> events;
    public final ObservableList<ToDoItemViewModel> items;

    public ToDoViewModel(ToDoRepository repository) {
        this.repository = repository;
        this.items = new ObservableArrayList<>();
        this.events = PublishSubject.create();
    }

    public void onAddTaskClick() {
        Log.d("ToDoViewModel", "onAddTaskClick");
        events.onNext(new ToDoEventModel(ToDoEventModel.EventType.ADD_ITEM));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void fetchToDoList() {
        Log.d(TAG, "fetchToDoList()");

        if (items.isEmpty()) {
            disposable = repository.getToDoList()
                                   .map(new ItemsToVmMapper())
                                   .subscribe(
                                           toDoItemViewModels -> onToDoListReceived(toDoItemViewModels),
                                           throwable -> {
                                               Log.e(TAG, "fetchToDoList error: ", throwable);
                                           });
        }
    }

    private void onToDoListReceived(List<ToDoItemViewModel> toDoItems) {
        Log.d(TAG, "onToDoListReceived " + toDoItems.size() + " items");
        items.clear();
        items.addAll(toDoItems);
    }

    //TODO 2: we now have a handler for item clicks: for the selected and deleted item
    // - inspect the interface
    // - check how we set it via binding in adapter
    @Override
    public void onItemSelected(ToDoItemViewModel item) {
        events.onNext(new ToDoEventModel(ToDoEventModel.EventType.EDIT_ITEM, item));
    }

    //TODO 4: call this method, from the item layout, for clicks on close imageView
    //TODO 5: test it out
    @SuppressLint("CheckResult")
    @Override
    public void onDeleteItemSelected(ToDoItemViewModel item) {
        repository.deleteItem(item.id).subscribe(
                () -> Log.e(TAG, "onDeleteItemSelected onComplete"),
                throwable -> Log.e(TAG, "onDeleteItemSelected error: ", throwable)
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.dispose();
        }
    }

}
