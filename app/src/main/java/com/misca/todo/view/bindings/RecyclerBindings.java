package com.misca.todo.view.bindings;


import com.misca.todo.feature.todolist.adapter.ToDoAdapter;
import com.misca.todo.feature.todolist.model.ToDoItemViewModel;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerBindings {

    @BindingAdapter({"items"})
    public static void addFeedItems(RecyclerView recyclerView, List<ToDoItemViewModel> tasks) {
        if (recyclerView.getAdapter() == null) {
            ToDoAdapter taskAdapter = new ToDoAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(taskAdapter);
        }

        ToDoAdapter adapter = (ToDoAdapter) recyclerView.getAdapter();
        adapter.setItems(tasks);
    }
}
