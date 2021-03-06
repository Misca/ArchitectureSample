package com.misca.todo.view.bindings;

import android.view.View;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

/**
 * Created by mihaimecea on 23.April.2019
 */
public class ViewBindings {

    @BindingAdapter("backgroundColor")
    public static void backgroundColor(View view, @ColorRes int colorRes) {
        int color = ContextCompat.getColor(view.getContext(), colorRes);
        view.setBackgroundColor(color);
    }

    @BindingAdapter("isVisible")
    public static void setViewVisibleOrGone(@Nullable View view, boolean isVisible) {
        if (view != null) {
            int visibility = isVisible ? View.VISIBLE : View.GONE;
            if (view.getVisibility() != visibility) {
                view.setVisibility(visibility);
            }
        }
    }

}
