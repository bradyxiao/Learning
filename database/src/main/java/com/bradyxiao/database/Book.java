package com.bradyxiao.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.lang.annotation.Retention;

/**
 * Created by bradyxiao on 2019-09-25.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
@Entity
public class Book {

    @NonNull
    @PrimaryKey
    public String name;

    public String publicAddress;

    @Override
    public String toString(){
        return "(name: " + name + ", publicAddress: " + publicAddress + ")";
    }

}
