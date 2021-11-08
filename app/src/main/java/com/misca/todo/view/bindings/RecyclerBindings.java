package com.misca.todo.view.bindings;


import com.misca.todo.feature.todolist.adapter.ToDoAdapter;
import com.misca.todo.feature.todolist.listener.ToDoHandler;
import com.misca.todo.feature.todolist.model.ToDoItemViewModel;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerBindings {

    @BindingAdapter({"items", "todoHandler"})
    public static void addFeedItems(RecyclerView recyclerView, List<ToDoItemViewModel> tasks, ToDoHandler handler) {
        ToDoAdapter taskAdapter = (ToDoAdapter) recyclerView.getAdapter();

        if (taskAdapter == null) {
            taskAdapter = new ToDoAdapter(handler);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(taskAdapter);
        }

        taskAdapter.setItems(tasks);
    }
}
