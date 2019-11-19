package com.besha.v13;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface VDao{
    @Insert
    public void insertVitamin(Vitamin vitamin);

    @Query("SELECT * FROM vitamins")
    public List<Vitamin> isNotNull();
}
