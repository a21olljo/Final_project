package com.example.final_project;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {

    private ArrayList<Result> results;

    public ResultAdapter(ArrayList<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public ResultAdapter.ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ResultViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ResultAdapter.ResultViewHolder holder, int position) {
        holder.name.setText(results.get(position).getName());
        holder.club.setText(results.get(position).getCompany());
        holder.position.setText(Integer.toString(results.get(position).getCost()));
        holder.time.setText(results.get(position).getSizeFormatted());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder {
        private final TextView name, club, position, time;

        public ResultViewHolder(@NonNull View itemView) {

            super(itemView);
            name = itemView.findViewById(R.id.name);
            club = itemView.findViewById(R.id.club);
            position = itemView.findViewById(R.id.position);
            time = itemView.findViewById(R.id.time);
        }
    }
}
