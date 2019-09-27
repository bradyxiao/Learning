package com.bradyxiao.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RoomDatabase;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

/**
 * Created by bradyxiao on 2019-09-25.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */

@Dao
public abstract class UserDaos {


    @Delete
    public abstract void delete(User user);

    @Delete
    public abstract void deletes(User ... users);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    public abstract void insert(User user);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    public abstract void insert(User ... users);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public abstract void updates(User user);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public abstract void updates(User... users);


    @Query(value = "SELECT * FROM user WHERE id = :number")
    public abstract User query(String number);

    @Query(value = "SELECT * FROM user WHERE address = :address")
    public abstract List<User> queryFromAddress(String address);

    @Query(value = "INSERT INTO user (id, user_name, address) VALUES (:number, :name, :address)")
    public abstract long insert(String number, String name, String address);


    @Query(value = "UPDATE user SET user_name = :name, address = :address WHERE id = :number")
    public abstract int update(String number, String name, String address);

    @Query(value = "DELETE FROM user WHERE user_name = :name ")
    public abstract int delete(String name);

    @Transaction
    public void insertAndDelete(User newUser, User oldUser){
        insert(newUser);
        delete(oldUser);
    }
}
