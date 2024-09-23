package com.pray.mindflow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MapItemAdapter extends RecyclerView.Adapter<MapItemAdapter.MapItemViewHolder> {
    private List<MapItem> mapItemList;

    public MapItemAdapter(List<MapItem> mapItemList) {
        this.mapItemList = mapItemList;
    }

    @NonNull
    @Override
    public MapItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.map_item, parent, false);
        return new MapItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapItemViewHolder holder, int position) {
        MapItem mapItem = mapItemList.get(position);
        holder.tvMapaNombre.setText(mapItem.getMapName());
    }

    @Override
    public int getItemCount() {
        return mapItemList.size();
    }

    public static class MapItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvMapaNombre;

        public MapItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMapaNombre = itemView.findViewById(R.id.tvMapaNombre);
        }
    }
}