package com.misca.todo.feature.todolist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.misca.todo.R;
import com.misca.todo.feature.todolist.model.ToDoViewModel;
import com.misca.todo.feature.todolist.model.ViewModelFactory;
import com.misca.todo.feature.todolist.navigator.ToDoNavigator;

import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    //TODO 1: just look around a bit:
    // - we got two fragments now
    // - one for list and one for detail/editing
    // - therefore we now have a navigator that listens to navigation events trough RxJava Subject (line 44)

    private final static String TAG = MainActivity.class.getSimpleName();
    private Disposable disposable;
    private ToDoNavigator navigator;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigator = new ToDoNavigator(getSupportFragmentManager());

        ViewModelFactory factory = new ViewModelFactory();
        ToDoViewModel viewModel = ViewModelProviders.of(this, factory).get(ToDoViewModel.class);

        disposable = viewModel.events.subscribe(
                toDoEventModel -> navigator.onToDoEvent(toDoEventModel),
                throwable -> Log.d(TAG, "")
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (disposable != null) {
            disposable.dispose();
        }
    }
}
