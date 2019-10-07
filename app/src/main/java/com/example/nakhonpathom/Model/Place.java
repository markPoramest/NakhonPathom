package com.example.nakhonpathom.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "place")
public class Place {
    @PrimaryKey(autoGenerate = true)
    public  int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "dis")
    public String dis;

    @ColumnInfo(name = "img")
    public int img;

    public Place(int id,String name, String dis , int img) {
        this.id = id;
        this.name = name;
        this.dis = dis;
        this.img = img;
    }
}
