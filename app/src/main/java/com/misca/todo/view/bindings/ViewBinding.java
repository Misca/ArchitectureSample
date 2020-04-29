package com.misca.todo.view.bindings;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

/**
 * Created by mihai.mecea on 29.April.2020
 */
class ViewBinding {

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
