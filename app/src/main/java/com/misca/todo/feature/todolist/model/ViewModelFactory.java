package com.misca.todo.feature.todolist.model;

import com.misca.data.ToDoRepository;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private ToDoRepository repository;

    public ViewModelFactory(ToDoRepository repository) {
        this.repository = repository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(ToDoViewModel.class)) {
            return (T) new ToDoViewModel(repository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}