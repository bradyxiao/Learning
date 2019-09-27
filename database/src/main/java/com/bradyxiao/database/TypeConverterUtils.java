package com.bradyxiao.database;

import androidx.room.TypeConverter;

import java.util.Date;

/**
 * Created by bradyxiao on 2019-09-25.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
public class TypeConverterUtils {

    @TypeConverter
    public String dateToTimestamp(Date date){
        if(date != null)return date.toString();
        return null;
    }

    @TypeConverter
    public Date fromTimeStamp(String timeStamp){
        if(timeStamp == null)return null;
        return new Date(timeStamp);
    }

}
