package com.bradyxiao.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Created by bradyxiao on 2019-09-25.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
public class DataBaseUtils {

    private static volatile SchoolDatabase schoolDatabase;

    public static SchoolDatabase getSchoolDatabase(Context context){
        if(schoolDatabase == null){
            synchronized (SchoolDatabase.class){
                schoolDatabase = Room.databaseBuilder(context, SchoolDatabase.class, "school_db")
                        .addMigrations(new Migration(1, 2) {
                            @Override
                            public void migrate(@NonNull SupportSQLiteDatabase database) {
                                String sql = "ALTER TABLE student_table ADD student_sex TEXT";
                                database.execSQL(sql);
                            }
                        }, new Migration(2, 3) {
                            @Override
                            public void migrate(@NonNull SupportSQLiteDatabase database) {
                                String sql_name = "ALTER TABLE student_table ADD book_name TEXT";
                                String sql_public = "ALTER TABLE student_table ADD book_publicAddress TEXT";
                                database.execSQL(sql_name);
                                database.execSQL(sql_public);
                            }
                        }, new Migration(3, 4) {
                            @Override
                            public void migrate(@NonNull SupportSQLiteDatabase database) {
                                String sql = "ALTER TABLE student_table ADD birthDay TEXT";
                                database.execSQL(sql);
                            }
                        })
                        .build();
            }
        }
        return schoolDatabase;
    }





    private static volatile UserDatabase userDatabase;

    public static UserDatabase getUserDatabase(Context context){
        if(userDatabase == null){
            synchronized (UserDatabase.class){
                userDatabase = Room.databaseBuilder(context, UserDatabase.class, "user_database")

                        .build();
            }
        }
        return userDatabase;
    }


}
