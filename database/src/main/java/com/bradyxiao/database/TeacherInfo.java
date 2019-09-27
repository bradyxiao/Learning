package com.bradyxiao.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by bradyxiao on 2019-09-27.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
@Entity(tableName = "teacher_table")
public class TeacherInfo {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "teacher_number")
    public int teacherNumber;

    @ColumnInfo
    public String name;

    @ColumnInfo
    public String skill;
}
