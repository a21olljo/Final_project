package com.example.final_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultAdapterViewHolder> {

    private ArrayList<Result> results;

    public ResultAdapter(ArrayList<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public ResultAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item, parent, false);
        return new ResultAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultAdapterViewHolder holder, int position) {
        holder.name.setText(results.get(position).getName());
        holder.clubb.setText(results.get(position).getCompany());
        holder.position.setText(results.get(position).getSize());
        holder.time.setText(results.get(position).getCost());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public ArrayList<Result> getResults() {
        return results;
    }

    public class ResultAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView name, clubb, position, time;
        public ResultAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            clubb = itemView.findViewById(R.id.clubb);
            position = itemView.findViewById(R.id.position);
            time = itemView.findViewById(R.id.time);
        }
    }
}
