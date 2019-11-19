package com.besha.v13;

import android.content.Context;

import androidx.room.Room;

public class VRepository {
    private final Context context;

    public VRepository(Context context) {
        this.context = context;
    }
    private VDataBase vDataBase;
    private static final Object myLock = new Object();
    public synchronized VDataBase getvDataBase(){
        if(vDataBase == null){
            synchronized (myLock){
                if(vDataBase == null){
                    vDataBase = Room.databaseBuilder(context, VDataBase.class, "vDatabase").build();
                }
            }
        }
        return vDataBase;
    }

}
