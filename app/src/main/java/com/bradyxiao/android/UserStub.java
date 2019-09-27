package com.bradyxiao.android;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by bradyxiao on 2019-09-23.
 * Copyright (c) 2016-2019 Tencent Cloud. All rights reserved.
 */
public class UserStub extends Binder implements UserBinderInterface {

    public UserStub(){
        this.attachInterface(this, UserBinderInterface.DESCRIPTOR);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    public static UserBinderInterface asInterface(IBinder obj){
        if(obj == null)return null;
        IInterface iin = obj.queryLocalInterface(UserBinderInterface.DESCRIPTOR);
        if((iin != null) && (iin instanceof UserBinderInterface)){
            return (UserBinderInterface) iin;
        }
        return new UserStub.Proxy(obj);
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.onTransact(code, data, reply, flags);
    }

    private static class Proxy implements UserBinderInterface{

        private IBinder remote;

        Proxy(IBinder obj){
            remote = obj;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public void setName(String name) {

        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }
}
