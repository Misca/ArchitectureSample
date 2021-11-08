package com.misca.todo.feature.todolist.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.misca.todo.databinding.TodoListFragmentBinding;
import com.misca.todo.feature.todolist.model.ToDoViewModel;
import com.misca.todo.feature.todolist.model.ViewModelFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ToDoListFragment extends Fragment {

    private ToDoViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModelFactory factory = new ViewModelFactory();
        viewModel = new ViewModelProvider(requireActivity(), factory).get(ToDoViewModel.class);

        //for those lifecycle callbacks in view model, like ON_CREATE
        getLifecycle().addObserver(viewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        TodoListFragmentBinding binding = TodoListFragmentBinding.inflate(inflater, container, false);

        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

}
