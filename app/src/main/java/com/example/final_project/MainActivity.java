package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    RecyclerView recyclerView;
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a21olljo";
    private ArrayList<Result> results = new ArrayList<Result>();
    ResultAdapter resultAdapter;

    private Button name;
    private Button place;
    private Button club;

    private final Comparator<Result> comparePlace = new Comparator<Result>() {
        @Override
        public int compare(Result r1, Result r2) {
            if(r1.getCost()==r2.getCost())
                return 0;
            else if(r1.getCost() > r2.getCost())
                return 1;
            else
                return -1;
        }
    };

    private final Comparator<Result> compareName = new Comparator<Result>() {
        @Override
        public int compare(Result r1, Result r2) {
            return r1.getName().compareTo(r2.getName());
        }
    };

    private final Comparator<Result> compareClub = new Comparator<Result>() {
        @Override
        public int compare(Result r1, Result r2) {
            return r1.getCompany().compareTo(r2.getCompany());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        resultAdapter = new ResultAdapter(results);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(resultAdapter);

        new JsonTask(this).execute(JSON_URL);

        place = findViewById(R.id.place_button);
        club = findViewById(R.id.club_button);
        name = findViewById(R.id.name_button);
        place.setOnClickListener(view -> {
            Collections.sort(results, comparePlace);
            resultAdapter.notifyDataSetChanged();
        });

        name.setOnClickListener(view -> {
            Collections.sort(results, compareName);
            resultAdapter.notifyDataSetChanged();
        });

        club.setOnClickListener(view -> {
            Collections.sort(results, compareClub);
            resultAdapter.notifyDataSetChanged();
        });
    }

    public void new_activity(View v) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();

        // Unmarshall JSON -> list of objects
        Type type = new TypeToken<ArrayList<Result>>() {}.getType();
        results = gson.fromJson(json, type);
        resultAdapter.setResults(results);
        Collections.sort(results, comparePlace);
        resultAdapter.notifyDataSetChanged();
    }
}