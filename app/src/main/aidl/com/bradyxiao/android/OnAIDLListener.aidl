// OnAIDLListener.aidl
package com.bradyxiao.android;

// Declare any non-default types here with import statements

interface OnAIDLListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onFinish(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
