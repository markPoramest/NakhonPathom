package com.example.nakhonpathom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nakhonpathom.Adapter.PlaceAdapter;
import com.example.nakhonpathom.Adapter.RecyclerAdapter;
import com.example.nakhonpathom.Model.Place;
import com.example.nakhonpathom.db.DatabaseHelper;
import com.example.nakhonpathom.room_db.AppDB;

import java.util.ArrayList;
import java.util.List;

import static com.example.nakhonpathom.db.DatabaseHelper.col_dis;
import static com.example.nakhonpathom.db.DatabaseHelper.col_id;
import static com.example.nakhonpathom.db.DatabaseHelper.col_imgRes;
import static com.example.nakhonpathom.db.DatabaseHelper.col_name;
import static com.example.nakhonpathom.db.DatabaseHelper.table_name;

public class MainActivity extends AppCompatActivity {
    /*private String[] mPlace = new String[]
            {"พระปฐมเจดีย์","พุทธมณฑล","ตลาดนัดดอนหวาย","ตลาดท่านา","วัดไร่ขิง","พิพิธภัณฑ์หุ่นขี้ผึ้ง"};*/
    private List<Place> listPlace = new ArrayList<Place>();
    private RecyclerAdapter mAdapter;
    private AppDB db;
   // private DatabaseHelper mDBHelper;
   // private SQLiteDatabase mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDB.getInstance(MainActivity.this);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Refresh();


            }
        });
        t1.start();







        // populateData();
       // mDBHelper = new DatabaseHelper(MainActivity.this);
        //mDatabase = mDBHelper.getWritableDatabase();
        //ReadfromDB();
        //insert

        Button addPlace = findViewById(R.id.add_place);
        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText placeName = findViewById(R.id.place_edit_text);
                String name = placeName.getText().toString();
                final Place place = new Place(0,name,"",R.drawable.logo);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        db.placeDao().insert_Place(place);
                        Refresh();

                    }
                });
                t.start();

            }
        });

        //Array Adapter
        //ArrayAdapter<String>  adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.item_place,R.id.place_name_txt,mPlace);
        //placeList.setAdapter(adapter);
        /*placeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String placeName = mPlace[i];
                Toast.makeText(MainActivity.this,placeName,Toast.LENGTH_SHORT).show();
            }
        });*/

        //Place Adapter
       /* PlaceAdapter adapter = new PlaceAdapter(MainActivity.this,R.layout.item_place,listPlace);
        placeList.setAdapter(adapter);
        placeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String placeName = listPlace.get(i).name;
                Toast.makeText(MainActivity.this,placeName,Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(MainActivity.this,PlaceDetailsActivity.class);
                i1.putExtra("name",listPlace.get(i).name);
                i1.putExtra("img",listPlace.get(i).img);
                startActivity(i1);
            }
        });*/

       //Recycler Adapter

      /* placeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String placeName = listPlace.get(i).name;
                Toast.makeText(MainActivity.this,placeName,Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(MainActivity.this,PlaceDetailsActivity.class);
                i1.putExtra("name",listPlace.get(i).name);
                i1.putExtra("img",listPlace.get(i).img);
                startActivity(i1);
            }
        });*/


    }

    private void Refresh() {
        listPlace = db.placeDao().getAllPlace();
        final RecyclerView placeList = findViewById(R.id.place_list_view);
        mAdapter = new RecyclerAdapter(MainActivity.this, R.layout.item_place, listPlace);
        final LinearLayoutManager ln = new LinearLayoutManager(MainActivity.this);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                placeList.setLayoutManager(ln);
                placeList.setAdapter(mAdapter);
            }
        });
    }



   /* private void ReadfromDB() {
        Cursor c1 =  mDatabase.query(table_name,null,null,null,null,null,null);
        listPlace.clear();
        while(c1.moveToNext())
        {
            int id = c1.getInt(c1.getColumnIndex(col_id));
            String name = c1.getString(c1.getColumnIndex(col_name));
            String dis = c1.getString(c1.getColumnIndex(col_dis));
            int imgRes = c1.getInt(c1.getColumnIndex(col_imgRes));
            Place place = new Place(id,name,dis,imgRes);
            listPlace.add(place);
        }
    }*/

 /*   private void populateData() {
        Place place1 = new Place("พระปฐมเจดีย์","เมือง" , R.drawable.jedi);
        listPlace.add(place1);
        Place place2 = new Place("พุทธมณฑล","พุทธมณฑล",R.drawable.buddhamonthon);
        listPlace.add(place2);
        Place place3 = new Place("ตลาดน้ำดอนหวาย","สามพราน",R.drawable.donwai);
        listPlace.add(place3);
        Place place4 = new Place("ลานแสดงช้างและฟาร์มจระเข้สามพราน","สามพราน",R.drawable.elephant);
        listPlace.add(place4);
        Place place5 = new Place("ตลาดท่านา","นครชัยศรี",R.drawable.thana);
        listPlace.add(place5);


    }*/

}

