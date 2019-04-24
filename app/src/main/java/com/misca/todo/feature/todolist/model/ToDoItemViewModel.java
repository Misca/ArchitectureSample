package com.misca.todo.feature.todolist.model;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

public class ToDoItemViewModel {

    @Nullable
    public Integer id;
    public final ObservableBoolean isChecked;
    public final ObservableField<String> taskName;
    @ColorRes
    public int priorityColor;

    public ToDoItemViewModel() {
        isChecked = new ObservableBoolean();
        taskName = new ObservableField<>();
    }

}
