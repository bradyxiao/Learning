package com.bradyxiao.glide;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.RawRes;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by bradyxiao on 2019-09-20.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
public class GlideManager {

    public  static void load(Context context, String url, ImageView view){
        Glide.with(context).load(url).into(view);
    }

    public static void load(Context context, File file, ImageView view){
        Glide.with(context).load(file).into(view);
    }

    public static void load(Context context, @RawRes int resId, ImageView view){
        Glide.with(context).load(resId).into(view);
    }

    public static void load(Context context, @Nullable byte[] bitmap, ImageView view){
        Glide.with(context).load(bitmap).into(view);
    }

    public static void load(Context context, Uri uri, ImageView view) {
        Glide.with(context).load(uri).into(view);
    }
}
