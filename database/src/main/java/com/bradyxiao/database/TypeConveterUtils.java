package com.bradyxiao.database;

import androidx.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bradyxiao on 2019-09-27.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
public class TypeConveterUtils {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

    @TypeConverter
    public String dateToFormat(Date date){
        if(date == null)return null;
        synchronized (TypeConverterUtils.class){
            return simpleDateFormat.format(date);
        }
    }

    @TypeConverter
    public Date formatToDate(String format){
        if(format == null)return null;
        synchronized (TypeConverterUtils.class){
            try {
                return simpleDateFormat.parse(format);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
