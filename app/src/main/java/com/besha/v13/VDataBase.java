package com.besha.v13;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Vitamin.class}, version = 1)
public abstract class VDataBase extends RoomDatabase {
    public abstract VDao vDao();
}
