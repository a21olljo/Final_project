package com.example.final_project;

import java.util.ArrayList;

public class Result {
    private String ID, name, company;
    private int size, cost;

    public Result(String id, String name, String company, int size, int cost) {
        this.ID = id;
        this.name = name;
        this.company = company;
        this.size = size;
        this.cost = cost;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }
}
