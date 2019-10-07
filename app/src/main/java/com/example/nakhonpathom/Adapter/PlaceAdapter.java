package com.example.nakhonpathom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.nakhonpathom.Model.Place;
import com.example.nakhonpathom.R;

import org.w3c.dom.Text;

import java.util.List;

public class PlaceAdapter extends ArrayAdapter<Place> {
    private Context mContext;
    private int mResource;
    private List<Place>  mPlaceList;
    public PlaceAdapter(@NonNull Context context, int resource,@NonNull  List<Place> placeList) {
        super(context, resource, placeList);
        this.mContext = context;
        this.mResource = resource;
        this.mPlaceList = placeList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull  ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = convertView;
        if(v == null) {
            v = inflater.inflate(mResource, parent, false);
        }
        Place place = mPlaceList.get(position);
        TextView txt = v.findViewById(R.id.place_name_txt);
        txt.setText(place.name);

        TextView txt2 = v.findViewById(R.id.place_name_dis);
        txt2.setText(String.format("อำเภอ %s", place.dis));

        ImageView img = v.findViewById(R.id.logo);
        img.setImageResource(place.img);
        return v;
    }
}

