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
                    //TODO 4 - check this out: we're using this RxJava operator to map from repository
                    .map(new ItemsToVmMapper())
                    .subscribe(new SingleObserver<List<ToDoItemViewModel>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            //TODO 1: keep the disposable refference in the view model disposable member
                        }

                        @Override
                        public void onSuccess(List<ToDoItemViewModel> toDoItems) {
                            //TODO 3: we recevied the list from repository; let's call onToDoListReceived here
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "fetchToDoList error: ", e);
                        }
                    });
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void saveToDoList() {
        Log.d(TAG, "saveToDoList()");
        //TODO 5 - check this out: and we're also using the mapper for saving, this way data and presentation are decoupled
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
            //TODO 2: dispose the disposable, this way we're not going to leak the view model when the system clears it

        }
    }
}
