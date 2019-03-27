package com.misca.data.feature.todo.local;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

//TODO 7: and only here we start to see the low-level way of saving things, this local data store uses ROOM ORM
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
