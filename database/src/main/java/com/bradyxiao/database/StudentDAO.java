package com.bradyxiao.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by bradyxiao on 2019-09-26.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
@Dao
public abstract class StudentDAO {

    @Insert
    public abstract void addStudent(StudentInfo... studentInfos);

    @Insert
    public abstract void addClass(ClassInfo... classInfos);

    @Delete
    public abstract void deleteStudent(StudentInfo... studentInfos);

    @Update
    public abstract void updateStudentInfo(StudentInfo... studentInfos);

    @Query(value = "SELECT * from student_table WHERE class_num = :classNum")
    public abstract List<StudentInfo> getStudents(int classNum);

    @Query("SELECT * FROM class_table")
    public abstract List<ClassAndStudent> getAll();
}