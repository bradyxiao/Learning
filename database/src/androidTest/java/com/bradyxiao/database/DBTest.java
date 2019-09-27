package com.bradyxiao.database;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

/**
 * Created by bradyxiao on 2019-09-26.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
@RunWith(AndroidJUnit4.class)
public class DBTest {

    private Context context = InstrumentationRegistry.getTargetContext();

    @Test
    public void testDB()throws Exception{
        SchoolDatabase schoolDatabase = DataBaseUtils.getSchoolDatabase(context);
        StudentDAO studentDAO = schoolDatabase.studentDAO();
        ClassInfo classInfo = new ClassInfo();
        classInfo.className = "一年级（1）班";
        classInfo.classNumber = 101;
        studentDAO.addClass(classInfo);
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.classNumber = 101;
        studentInfo.studentName = "小程序员";
        studentInfo.studentNumber = 1;
        studentDAO.addStudent(studentInfo);

        List<StudentInfo> studentInfoList = studentDAO.getStudents(classInfo.classNumber);
        Assert.assertEquals(1, studentInfoList.size());
        Assert.assertEquals(classInfo.classNumber, studentInfoList.get(0).classNumber);
        Assert.assertEquals(studentInfo.studentNumber, studentInfoList.get(0).studentNumber);
        Assert.assertEquals(studentInfo.studentName, studentInfoList.get(0).studentName);

//        System.out.println(studentInfoList.get(0).toString());
    }

    @Test
    public void testDBMigiration() throws Exception{
        SchoolDatabase schoolDatabase = DataBaseUtils.getSchoolDatabase(context);
        StudentDAO studentDAO = schoolDatabase.studentDAO();
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.classNumber = 101;
        studentInfo.studentName = "小程序员";
        studentInfo.studentNumber = 1;
        studentInfo.sex = StudentInfo.SEX_MALE;
        Book book = new Book();
        book.name = "Android 设计";
        book.publicAddress = "CSDN 出版社";
        studentInfo.book = book;
        studentInfo.date = new Date(1990 - 1900, 11, 29);
        studentDAO.updateStudentInfo(studentInfo);
        List<StudentInfo> studentInfoList = studentDAO.getStudents(studentInfo.classNumber);
        Assert.assertEquals(1, studentInfoList.size());
        Assert.assertEquals(studentInfo.classNumber, studentInfoList.get(0).classNumber);
        Assert.assertEquals(studentInfo.studentNumber, studentInfoList.get(0).studentNumber);
        Assert.assertEquals(studentInfo.studentName, studentInfoList.get(0).studentName);
        Assert.assertEquals(studentInfo.sex, studentInfoList.get(0).sex);
        Assert.assertEquals(studentInfo.book.name, studentInfoList.get(0).book.name);
        Assert.assertEquals(studentInfo.book.publicAddress, studentInfoList.get(0).book.publicAddress);
        System.out.println(studentInfoList.get(0).toString());

    }

    @Test
    public void testGetAll(){
        SchoolDatabase schoolDatabase = DataBaseUtils.getSchoolDatabase(context);
        StudentDAO studentDAO = schoolDatabase.studentDAO();
        List<ClassAndStudent> classAndStudents = studentDAO.getAll();
        System.out.println(classAndStudents.size());
        for(ClassAndStudent classAndStudent : classAndStudents){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(classAndStudent.className + ", " + classAndStudent.classNumber)
                    .append("{");
            for(StudentInfo studentInfo : classAndStudent.studentInfos){
                stringBuffer.append(studentInfo.studentName).append(",")
                        .append(studentInfo.studentNumber).append(",")
                        .append(studentInfo.studentName);
            }
            stringBuffer.append("}");
            System.out.println(stringBuffer.toString());

        }
    }
}
