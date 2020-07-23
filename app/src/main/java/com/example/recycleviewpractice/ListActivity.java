package com.example.recycleviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
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

        myAdapter = new MultiAdapter(dataList);
        recyclerView.setAdapter(myAdapter);
    }

    public void doData() {
        dataList.add(new Data(Data.TYPE_HEADER, "This is header", null, 0, null));
        for (int i = 0; i < 15; i++) {
            int number = i+1;
            String title = "Title " + number;
            String description = "Description " + number;
            String avatar = "https://loremflickr.com/180/180?lock=" + number;
            Data data = new Data(Data.TYPE_ITEM, title, description, number, avatar);
            dataList.add(data);
        }
    }
}