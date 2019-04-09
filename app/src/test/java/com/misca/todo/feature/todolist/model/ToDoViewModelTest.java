package com.misca.todo.feature.todolist.model;

import android.util.Log;

import com.misca.data.ToDoRepository;
import com.misca.data.feature.todo.local.ToDoEntity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

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
        Mockito.doReturn(Single.just(new ArrayList<List<ToDoEntity>>()))
                .when(repository).getToDoList();

        viewModel.fetchToDoList();

        Mockito.verify(repository).getToDoList();
    }
}
