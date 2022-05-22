package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    RecyclerView recyclerView;
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a21olljo";
    private ArrayList<Result> results = new ArrayList<Result>();
    ResultAdapter resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        resultAdapter = new ResultAdapter(results);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(resultAdapter);

        new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();

        // Unmarshall JSON -> list of objects
        Type type = new TypeToken<ArrayList<Result>>() {}.getType();
        results = gson.fromJson(json, type);
        Log.d("Onposter", String.valueOf(json));
        Log.d("Onposter", String.valueOf(results));
        resultAdapter.setResults(results);

        resultAdapter.notifyDataSetChanged();
    }
}