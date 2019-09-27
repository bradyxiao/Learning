package com.bradyxiao.database;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

/**
 * Created by bradyxiao on 2019-09-26.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
@Entity(tableName = "student_table", foreignKeys = {@ForeignKey(entity = ClassInfo.class, parentColumns = {"class_num"},
        childColumns = {"class_num"})}, primaryKeys = {"student_num", "class_num"})
public class StudentInfo {
    @ColumnInfo(name = "student_num")
    public int studentNumber;

    @NonNull
    @ColumnInfo(name = "student_name")
    public String studentName;

    @ColumnInfo(name = "class_num")
    public int classNumber;

    @ColumnInfo(name = "student_sex")
    @SEX
    public String sex;

    @Embedded(prefix = "book_")
    public Book book;


    @ColumnInfo(name = "birthDay")
    public Date date;

    @Override
    public String toString(){
        return "(student_number: " + studentNumber + ", student_name: " + studentName + ", birthDay: " + (date == null ? "unknown" : date.toString()) +", student_sex: "
                + sex + ", class_num: " + classNumber +", book: "+ (book == null ? "null" : book.toString()) + ")";
    }


    @StringDef({SEX_FEMALE, SEX_MALE})
    public @interface SEX{

    }
    public final static String SEX_MALE = "男";
    public final static String SEX_FEMALE = "女";
}
