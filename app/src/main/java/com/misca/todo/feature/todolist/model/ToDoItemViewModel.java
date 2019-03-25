package com.misca.todo.feature.todolist.model;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

public class ToDoItemViewModel {

    public ObservableBoolean isChecked;
    public ObservableField<String> taskName;

    public ToDoItemViewModel() {
        isChecked = new ObservableBoolean();
        taskName = new ObservableField<>();
    }

}
