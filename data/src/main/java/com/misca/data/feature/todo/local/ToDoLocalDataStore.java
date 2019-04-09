package com.misca.data.feature.todo.local;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class ToDoLocalDataStore {

    private ToDoDao dao;

    public ToDoLocalDataStore(ToDoDao dao) {
        this.dao = dao;
    }

    public Single<List<ToDoEntity>> getToDoList() {
        return dao.queryToDos();
    }

    public Completable saveToDos(List<ToDoEntity> toDoList) {
        return dao
                .deleteAllToDos()
                .andThen(dao.insertToDos(toDoList));
    }
}
