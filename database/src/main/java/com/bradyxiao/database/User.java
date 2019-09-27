package com.bradyxiao.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Date;

/**
 * Created by bradyxiao on 2019-09-25.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
@Entity(tableName = "user")
public class User {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    public String number;

    @ColumnInfo(name = "user_name")
    public String name;

    public String address;

    @Embedded(prefix = "book_")
    public Book book;

    @TypeConverters({TypeConverterUtils.class})
    public Date date;
}
