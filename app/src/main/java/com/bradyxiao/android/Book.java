package com.bradyxiao.android;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bradyxiao on 2019-09-23.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
public class Book implements Parcelable {
    protected Book(Parcel in) {
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
