package com.example.nakhonpathom.room_db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.nakhonpathom.Model.Place;

import java.util.List;

@Dao
public interface PlaceDao {
    @Query("Select * from  place")
    List<Place> getAllPlace();

    @Insert
    void insert_Place(Place place);

}
