package com.example.recycleviewpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Data> dataList = new ArrayList<Data>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        doData();

        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
    }

    public void doData() {
        dataList.add(new Data(Data.TYPE_HEADER, "This is header", null, 0));
        for (int i = 0; i < 15; i++) {
            int number = i+1;
            String title = "Title " + number;
            String description = "Description " + number;
            Data data = new Data(Data.TYPE_ITEM, title, description, number);
            dataList.add(data);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        class ItemViewHolder extends RecyclerView.ViewHolder {
            public View itemView;
            public TextView title, description, number;
            public ItemViewHolder(View v) {
                super(v);
                itemView = v;
                title = itemView.findViewById(R.id.item_title);
                description = itemView.findViewById(R.id.item_description);
                number = itemView.findViewById(R.id.item_number);
            }
        }

        class HeaderViewHolder extends RecyclerView.ViewHolder {
            public View itemView;
            public TextView title;
            public HeaderViewHolder(View v) {
                super(v);
                itemView = v;
                title = itemView.findViewById(R.id.item_title);
            }
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
            switch (dataList.get(position).getType()) {
                case 0:
                    return Data.TYPE_ITEM;
                case 1:
                    return Data.TYPE_HEADER;
                default:
                    return -1;
            }
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }
}