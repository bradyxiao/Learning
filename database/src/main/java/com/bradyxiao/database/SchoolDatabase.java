package com.bradyxiao.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * Created by bradyxiao on 2019-09-26.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
@TypeConverters(value = {TypeConverterUtils.class})
@Database(entities = {StudentInfo.class, ClassInfo.class, TeacherInfo.class}, version = 5, exportSchema = true)
public abstract class SchoolDatabase extends RoomDatabase {
    public abstract StudentDAO studentDAO();
}
