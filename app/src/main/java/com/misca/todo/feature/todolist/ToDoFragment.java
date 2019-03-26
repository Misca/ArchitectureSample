package com.misca.todo.feature.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.misca.todo.databinding.TodoFragmentBinding;
import com.misca.todo.feature.todolist.model.ToDoViewModel;
import com.misca.todo.feature.todolist.model.ViewModelFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class ToDoFragment extends Fragment {

    private ToDoViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModelFactory factory = new ViewModelFactory();
        mViewModel = ViewModelProviders.of(this, factory).get(ToDoViewModel.class);

        //for those lifecycle callbacks in view model, like ON_CREATE
        getLifecycle().addObserver(mViewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        TodoFragmentBinding binding = TodoFragmentBinding.inflate(inflater, container, false);

        binding.setViewModel(mViewModel);

        return binding.getRoot();
    }

}
