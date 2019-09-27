package com.bradyxiao.android;

import android.os.IBinder;
import android.os.IInterface;

/**
 * Created by bradyxiao on 2019-09-23.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
public interface UserBinderInterface extends IInterface {
    String DESCRIPTOR = "com.bradyxiao.android.userBinderInterface";

    int TRANSACTION_getName = IBinder.FIRST_CALL_TRANSACTION + 0;
    int TRANSACTION_setName = IBinder.FIRST_CALL_TRANSACTION + 1;

    String getName();
    void setName(String name);
}
