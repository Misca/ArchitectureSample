package com.misca.data.store.local;

import com.misca.data.feature.todo.local.ToDoDao;
import com.misca.data.feature.todo.local.ToDoEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ToDoEntity.class}, version = 1)
public abstract class ToDoDatabase extends RoomDatabase {

    public abstract ToDoDao ToDoDao();

}
