package com.misca.data.feature.todo.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todos")
public class ToDoEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public int priority;

    public boolean isChecked;

    public String taskName;

}