package com.misca.todo.feature.todolist.model;

import androidx.annotation.IntDef;

/**
 * Created by mihaimecea on 23.April.2019
 */
@IntDef({
        ToDoPriority.LEVEL_ZERO,
        ToDoPriority.LEVEL_ONE,
        ToDoPriority.LEVEL_TWO,
        ToDoPriority.LEVEL_THREE
})
public @interface ToDoPriority {
    //level zero is the most important
    int LEVEL_ZERO = 0;
    int LEVEL_ONE = 1;
    int LEVEL_TWO = 2;
    int LEVEL_THREE = 3;
}
