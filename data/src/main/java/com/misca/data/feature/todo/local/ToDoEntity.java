package com.misca.data.feature.todo.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todos")
public class ToDoEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public boolean isChecked;

    public String taskName;

}
