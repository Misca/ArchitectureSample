package com.misca.todo.feature.todolist.model;


public class ToDoEventModel {
    public final EventType eventType;

    public final ToDoItemViewModel item;

    ToDoEventModel(EventType eventType, ToDoItemViewModel item) {
        this.eventType = eventType;
        this.item = item;
    }

    ToDoEventModel(EventType eventType) {
        this.eventType = eventType;
        this.item = null;
    }

    public enum EventType {
        EDIT_ITEM,
        ADD_ITEM;
    }

}
