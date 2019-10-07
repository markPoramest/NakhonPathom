package com.example.nakhonpathom.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nakhonpathom.R;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db";
    private static final int  DATABASE_VERSION = 1;

    public static final String table_name = "place";
    public static final String col_id = "_id";
    public static final String col_name = "name";
    public static final String col_dis = "dis";
    public static final String col_imgRes = "imgRes";

    private static final String SQL_CREATE_PLACE = "CREATE TABLE "+table_name+" ("+col_id+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
            +col_name+" TEXT, "+col_dis+" TEXT, "+col_imgRes+" INTEGER)";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME , null,  DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      sqLiteDatabase.execSQL(SQL_CREATE_PLACE);
        ContentValues cv = new ContentValues();
        cv.put(col_name,"พระปฐมเจดีย์");
        cv.put(col_dis,"เมือง");
        cv.put(col_imgRes, R.drawable.jedi);
        sqLiteDatabase.insert(table_name,null,cv);
        cv = new ContentValues();
        cv.put(col_name,"พุทธมณฑล");
        cv.put(col_dis,"พุทธมณฑล");
        cv.put(col_imgRes, R.drawable.buddhamonthon);
        sqLiteDatabase.insert(table_name,null,cv);
        cv = new ContentValues();
        cv.put(col_name,"ตลาดน้ำดอนหวาย");
        cv.put(col_dis,"สามพราน");
        cv.put(col_imgRes, R.drawable.donwai);
        sqLiteDatabase.insert(table_name,null,cv);
        cv = new ContentValues();
        cv.put(col_name,"ลานแสดงช้างและฟาร์มจรเข้สามพราน");
        cv.put(col_dis,"สามพราน");
        cv.put(col_imgRes, R.drawable.elephant);
        sqLiteDatabase.insert(table_name,null,cv);
        cv = new ContentValues();
        cv.put(col_name,"ตลาดท่านา");
        cv.put(col_dis,"นครชัยศรี");
        cv.put(col_imgRes, R.drawable.thana);
        sqLiteDatabase.insert(table_name,null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
