package com.example.nakhonpathom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nakhonpathom.Model.Place;
import com.example.nakhonpathom.R;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private Context mContext;
    private int mResource;
    private List<Place> mPlaceList;

    public RecyclerAdapter(Context mContext, int mResource, List<Place> mPlaceList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mPlaceList = mPlaceList;
    }

    @Override
    public int getItemCount() {
        return mPlaceList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Place place = mPlaceList.get(position);

        holder.name.setText(place.name);
        holder.Dis.setText(place.dis);
        holder.img.setImageResource(place.img);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource,parent,false);
        return new MyViewHolder(view);
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView Dis;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.place_name_txt);
            this.Dis = itemView.findViewById(R.id.place_name_dis);
            this.img = itemView.findViewById(R.id.logo);
        }

    }

}
