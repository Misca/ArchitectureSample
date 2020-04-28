package com.misca.todo.feature.edittodo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.misca.todo.databinding.TodoDetailsFragmentBinding;
import com.misca.todo.feature.edittodo.model.ToDoDetailsViewModel;
import com.misca.todo.feature.todolist.model.ViewModelFactory;

public class ToDoDetailFragment extends Fragment {

    public final static String EXTRA_TODO_ITEM_ID = "EXTRA_TODO_ITEM_ID";
    private ToDoDetailsViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModelFactory factory = new ViewModelFactory();
        viewModel = ViewModelProviders.of(this, factory).get(ToDoDetailsViewModel.class);

        if (getArguments() != null && getArguments().containsKey(EXTRA_TODO_ITEM_ID)) {
            viewModel.initToDoItem(getArguments().getInt(EXTRA_TODO_ITEM_ID));
        }

        getLifecycle().addObserver(viewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        TodoDetailsFragmentBinding binding = TodoDetailsFragmentBinding.inflate(inflater, container, false);

        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

}
