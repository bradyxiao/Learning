package com.bradyxiao.database;

import androidx.core.content.res.TypedArrayUtils;
import androidx.room.Database;
import androidx.room.TypeConverters;

/**
 * Created by bradyxiao on 2019-09-25.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 *
 *  It should be an abstract class that extends RoomDatabase.
 *  At runtime, you can acquire an instance of it via Room.databaseBuilder or Room.inMemoryDatabaseBuilder.
 */
@Database(entities = {User.class}, version = 1, exportSchema = true)
public abstract class UserDatabase extends androidx.room.RoomDatabase {

    public abstract UserDaos userDaos();
}
