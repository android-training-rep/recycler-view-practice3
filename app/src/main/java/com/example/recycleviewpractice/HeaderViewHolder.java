package com.example.recycleviewpractice;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    public View itemView;
    public TextView title;
    public HeaderViewHolder(View v) {
        super(v);
        itemView = v;
        title = itemView.findViewById(R.id.item_title);
    }
}
