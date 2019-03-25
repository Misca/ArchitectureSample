package com.misca.todo.feature.todolist.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.misca.todo.databinding.TodoItemBinding;
import com.misca.todo.feature.todolist.model.ToDoItemViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.TaskViewHolder> {

    private List<ToDoItemViewModel> taskModelList;

    public ToDoAdapter() {
        this.taskModelList = new ArrayList<>();
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TodoItemBinding binder = TodoItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new TaskViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.binding.setViewmodel(taskModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return taskModelList.size();
    }

    public void setItems(List<ToDoItemViewModel> blogList) {
        taskModelList = blogList;
        notifyDataSetChanged();
    }


    public class TaskViewHolder extends RecyclerView.ViewHolder {
        final TodoItemBinding binding;

        public TaskViewHolder(TodoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}