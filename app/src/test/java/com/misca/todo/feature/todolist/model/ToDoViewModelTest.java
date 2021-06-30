package com.misca.todo.feature.todolist.model;

import android.util.Log;

import com.misca.data.ToDoRepository;
import com.misca.data.feature.todo.local.ToDoEntity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * Created by mihaimecea on 09.April.2019
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Log.class)
public class ToDoViewModelTest {

    private ToDoViewModel viewModel;

    @Mock
    ToDoRepository repository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(Log.class);

        viewModel = new ToDoViewModel(repository);
    }

    @Test
    public void fetchToDoList_whenOnCreate_shouldCallGetToDosOnRepo() {
        Mockito.doReturn(Flowable.just(new ArrayList<List<ToDoEntity>>()))
               .when(repository).getToDoList();

        viewModel.fetchToDoList();

        Mockito.verify(repository).getToDoList();
    }

    @Test
    public void fetchToDoList_whenAlreadyHavingAlist_shouldNotCallFetchList() {
        Mockito.doReturn(Flowable.just(new ArrayList<List<ToDoEntity>>()))
               .when(repository).getToDoList();
        viewModel.items.add(new ToDoItemViewModel());

        viewModel.fetchToDoList();

        Mockito.verify(repository, Mockito.never()).getToDoList();
    }

    @Test
    public void onDeleteItemSelected_withItem_shouldCallRepository() {
        ToDoItemViewModel someItem = new ToDoItemViewModel();
        someItem.id = 3;
        PowerMockito.when(repository.deleteItem(ArgumentMatchers.anyInt())).thenReturn(Completable.complete());

        viewModel.onDeleteItemSelected(someItem);

        Mockito.verify(repository).deleteItem(someItem.id);
    }
}
