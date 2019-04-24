package com.misca.data.feature.todo.local;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface ToDoDao {

    @Query("SELECT * FROM todos")
    Flowable<List<ToDoEntity>> queryToDos();

    @Query("SELECT * FROM todos where id= :id")
    Single<ToDoEntity> queryToDoItem(int id);

    @Query("DELETE FROM todos where id=:id")
    Completable deleteToDoItem(int id);

    @Query("DELETE FROM todos")
    Completable deleteAllToDos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertToDos(List<ToDoEntity> todos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertToDo(ToDoEntity todo);

    @Query("UPDATE todos SET taskName = :taskName, priority = :priority where id=:id")
    Completable updateProfile(String taskName, int priority, int id);

}
