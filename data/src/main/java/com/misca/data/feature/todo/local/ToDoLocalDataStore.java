package com.misca.data.feature.todo.local;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class ToDoLocalDataStore {

    private final ToDoDao dao;

    public ToDoLocalDataStore(ToDoDao dao) {
        this.dao = dao;
    }

    public Flowable<List<ToDoEntity>> getToDoList() {
        return dao.queryToDos();
    }

    public Single<ToDoEntity> getToDoItem(int id) {
        return dao.queryToDoItem(id);
    }

    public Completable deleteToDoItem(int id) {
        return dao.deleteToDoItem(id);
    }

    public Completable saveItem(ToDoEntity toDo) {
        if(toDo.id == null) {
            return dao.insertToDo(toDo);
        } else {
            return dao.updatePriority(toDo.taskName, toDo.priority, toDo.id);
        }
    }

}
