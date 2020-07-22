package com.example.recycleviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button recycleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleBtn = findViewById(R.id.to_recycle_view);
        recycleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRecycleView();
            }
        });
    }

    private void toRecycleView() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}