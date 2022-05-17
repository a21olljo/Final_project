package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a21olljo";

    private ArrayList<Result> results;
    private ResultAdapter resultAdapter;
    private RecyclerView recyclerView;

//    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        resultAdapter = new ResultAdapter(results);
        recyclerView.setAdapter(resultAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}