package com.keval.rideme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewMapViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context c;
    private ArrayList<DataModel> dataSet;

    public RecyclerViewMapViewAdapter(Context context, ArrayList<DataModel> data) {
        c = context;
        this.dataSet = data;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MapViewListItemView mapViewListItemView = new MapViewListItemView(c);
        mapViewListItemView.mapViewOnCreate(null);
        //mMapViewListItemViews.add(mapViewListItemView);
        return new MapViewHolder(mapViewListItemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MapViewHolder mapViewHolder = (MapViewHolder) holder;
        TextView textViewName = ((MapViewHolder) holder).textViewName;
        TextView textViewVersion = ((MapViewHolder) holder).textViewVersion;
        ImageView imageView = ((MapViewHolder) holder).imageViewIcon;
        textViewName.setText(dataSet.get(position).getName());
        textViewVersion.setText(dataSet.get(position).getVersion());
        imageView.setImageResource(dataSet.get(position).getImage());
        mapViewHolder.mapViewListItemViewOnResume();
    }
}