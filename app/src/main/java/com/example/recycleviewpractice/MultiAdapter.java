package com.example.recycleviewpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MultiAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Data> dataList;

    public MultiAdapter(List<Data> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        switch (viewType) {
            case Data.TYPE_HEADER:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
                return new HeaderViewHolder(itemView);
            case Data.TYPE_ITEM:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
                return new ItemViewHolder(itemView);
        }
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data currentData = dataList.get(position);
        switch (currentData.getType()) {
            case Data.TYPE_HEADER:
                ((HeaderViewHolder)holder).title.setText(currentData.getTitle());
                break;
            case Data.TYPE_ITEM:
                ((ItemViewHolder)holder).title.setText(currentData.getTitle());
                ((ItemViewHolder)holder).description.setText(currentData.getDescription());
                ((ItemViewHolder)holder).number.setText("" + currentData.getNumber());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}