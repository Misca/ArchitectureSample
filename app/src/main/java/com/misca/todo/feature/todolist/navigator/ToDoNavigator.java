package com.misca.todo.feature.todolist.navigator;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.misca.todo.R;
import com.misca.todo.feature.todolist.ToDoDetailFragment;
import com.misca.todo.feature.todolist.model.ToDoEventModel;
import com.misca.todo.feature.todolist.model.ToDoItemViewModel;

/**
 * Created by mihaimecea on 22.April.2019
 */
public class ToDoNavigator {

    private FragmentManager fragmentManager;

    public ToDoNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void onToDoEvent(ToDoEventModel toDoEventModel) {
        switch (toDoEventModel.eventType) {
            case ToDoEventModel.EventType.EDIT_ITEM:
                openToDoEditDetailScreen(toDoEventModel.item);
                break;
            case ToDoEventModel.EventType.ADD_ITEM:
                openToDoAddDetailScreen();
                break;
        }
    }

    private void openToDoEditDetailScreen(ToDoItemViewModel item) {
        ToDoDetailFragment fragment = new ToDoDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ToDoDetailFragment.EXTRA_TODO_ITEM_ID, item.id);

        fragment.setArguments(bundle);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment, ToDoDetailFragment.class.getSimpleName());
        transaction.addToBackStack(fragment.getClass().getSimpleName());

        transaction.commit();
    }

    private void openToDoAddDetailScreen() {
        ToDoDetailFragment fragment = new ToDoDetailFragment();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.main_container, fragment, ToDoDetailFragment.class.getSimpleName());
        transaction.addToBackStack(fragment.getClass().getSimpleName());

        transaction.commit();
    }
}
