package com.example.recycleviewpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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
        for (int i = 0; i < 15; i++) {
            int number = i+1;
            String title = "Title " + number;
            String description = "Description " + number;
            Data data = new Data(title, description, number);
            dataList.add(data);
        }
    }

    class Data{
        public String title;
        public String description;
        public int number;

        public Data(String title, String description, int number) {
            this.title = title;
            this.description = description;
            this.number = number;
        }

        public String getTitle() {
            return title;
        }
        public String getDescription() {
            return description;
        }
        public int getNumber() {
            return number;
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        class MyViewHolder extends RecyclerView.ViewHolder {
            public View itemView;
            public TextView title, description, number;
            public MyViewHolder(View v) {
                super(v);
                itemView = v;
                title = itemView.findViewById(R.id.item_title);
                description = itemView.findViewById(R.id.item_description);
                number = itemView.findViewById(R.id.item_number);
            }
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            MyViewHolder vh = new MyViewHolder(itemView);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
            holder.title.setText(dataList.get(position).getTitle());
            holder.description.setText(dataList.get(position).getDescription());
            holder.number.setText("" + dataList.get(position).getNumber());
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }
}