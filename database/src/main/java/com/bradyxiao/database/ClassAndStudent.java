package com.bradyxiao.database;

import androidx.room.ColumnInfo;
import androidx.room.Relation;

import java.util.List;

/**
 * Created by bradyxiao on 2019-09-27.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
public class ClassAndStudent {
    @ColumnInfo(name = "class_num")
    public int classNumber;
    @ColumnInfo(name = "class_name")
    public String className;
    @Relation(parentColumn = "class_num", entityColumn = "class_num")
    List<StudentInfo> studentInfos;
}
