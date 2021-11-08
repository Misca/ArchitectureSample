package com.misca.todo.view.bindings;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

/**
 * Created by mihai.mecea on 29.April.2020
 */
class ImageBinding {

    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView imageView, @Nullable String url) {
        Glide
                .with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    @BindingAdapter({"imageUrl", "placeholder"})
    public static void setImageUrl(ImageView imageView, @Nullable String url, @DrawableRes int placeHolder) {
        Glide
                .with(imageView.getContext())
                .load(url)
                .fallback(placeHolder)
                .into(imageView);
    }

}
