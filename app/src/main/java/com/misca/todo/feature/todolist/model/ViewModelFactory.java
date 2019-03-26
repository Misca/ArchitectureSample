package com.misca.todo.feature.todolist.model;

import com.misca.data.ToDoRepository;
import com.misca.todo.ToDoApplication;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(ToDoViewModel.class)) {
            ToDoRepository repo = ToDoApplication.getRepoProvider().provideToDoRepository();
            return (T) new ToDoViewModel(repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}