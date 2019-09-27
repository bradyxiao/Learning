package com.bradyxiao.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by bradyxiao on 2019-09-26.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
@Entity(tableName = "class_table")
public class ClassInfo {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "class_num")
    public int classNumber;

    @NonNull
    @ColumnInfo(name = "class_name")
    public String className;
}
