package com.misca.todo.feature.todolist.model;

import androidx.annotation.IntDef;

public class ToDoEventModel {

    @EventType
    public final int eventType;

    public final ToDoItemViewModel item;

    ToDoEventModel(@EventType int eventType, ToDoItemViewModel item) {
        this.eventType = eventType;
        this.item = item;
    }

    ToDoEventModel(@EventType int eventType) {
        this.eventType = eventType;
        this.item = null;
    }

    @IntDef({
            EventType.EDIT_ITEM,
            EventType.ADD_ITEM
    })
    public @interface EventType {
        int EDIT_ITEM = 1;
        int ADD_ITEM = 2;
    }

}
