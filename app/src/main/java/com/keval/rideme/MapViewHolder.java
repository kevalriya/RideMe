package com.keval.rideme;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class MapViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewName;
    TextView textViewVersion;
    ImageView imageViewIcon;
    MapView mapView;
    private MapViewListItemView mMapViewListItemView;

    public MapViewHolder(MapViewListItemView mapViewListItemView) {
        super(mapViewListItemView);
        mMapViewListItemView = mapViewListItemView;
        this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
        this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
        this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        this.mapView = (MapView) itemView.findViewById(R.id.fragment_embedded_map_view_mapview);
    }

    public void mapViewListItemViewOnCreate(Bundle savedInstanceState) {
        if (mMapViewListItemView != null) {
            mMapViewListItemView.mapViewOnCreate(savedInstanceState);
        }
    }

    public void mapViewListItemViewOnResume() {
        if (mMapViewListItemView != null) {
            mMapViewListItemView.mapViewOnResume();
        }
    }

    public void mapViewListItemViewOnPause() {
        if (mMapViewListItemView != null) {
            mMapViewListItemView.mapViewOnPause();
        }
    }

    public void mapViewListItemViewOnDestroy() {
        if (mMapViewListItemView != null) {
            mMapViewListItemView.mapViewOnDestroy();
        }
    }

    public void mapViewListItemViewOnLowMemory() {
        if (mMapViewListItemView != null) {
            mMapViewListItemView.mapViewOnLowMemory();
        }
    }

    public void mapViewListItemViewOnSaveInstanceState(Bundle outState) {
        if (mMapViewListItemView != null) {
            mMapViewListItemView.mapViewOnSaveInstanceState(outState);
        }
    }
}