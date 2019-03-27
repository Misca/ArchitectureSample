package com.misca.data.feature.todo.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//TODO 9: An entity models a relational table
@Entity(tableName = "todos")
public class ToDoEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public boolean isChecked;

    public String taskName;

}
