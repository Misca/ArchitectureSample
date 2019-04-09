package com.misca.data.feature.todo.local;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ToDoDao {

    @Query("SELECT * FROM todos")
    Single<List<ToDoEntity>> queryToDos();

    @Query("DELETE FROM todos")
    Completable deleteAllToDos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertToDos(List<ToDoEntity> todos);

}
