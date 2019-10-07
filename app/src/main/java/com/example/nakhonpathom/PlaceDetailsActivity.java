package com.example.nakhonpathom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlaceDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        Intent i1 = getIntent();
        String name = i1.getStringExtra("name");
        int img = i1.getIntExtra("img",0);
        TextView txt = findViewById(R.id.textView);
        txt.setText(name);
        ImageView imgV = findViewById(R.id.imageView);
        imgV.setImageResource(img);
    }
}
