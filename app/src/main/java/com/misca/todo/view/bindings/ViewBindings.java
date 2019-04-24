package com.misca.todo.view.bindings;

import android.view.View;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

/**
 * Created by mihaimecea on 23.April.2019
 */
public class ViewBindings {

    @BindingAdapter({"backgroundColor"})
    public static void addFeedItems(View view, @ColorRes int colorRes) {
        int color = ContextCompat.getColor(view.getContext(), colorRes);
        view.setBackgroundColor(color);
    }

}
