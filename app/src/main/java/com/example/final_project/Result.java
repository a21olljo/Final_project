package com.example.final_project;

import android.util.Log;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Result {
    private String ID,name, company;
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

    public String getSizeFormatted() {
        String time = Integer.toString(size);
        int[] numbers = new int[time.length()];
        for (int i = 0; i < time.length(); i++)
            numbers[i] = time.charAt(i) - '0';
        return numbers[0] + ":" + numbers[1] + numbers[2] + ":" + numbers[3] + numbers[4];
    }

    public int getCost() {
        return cost;
    }
}
