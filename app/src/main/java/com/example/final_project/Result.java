package com.example.final_project;

import android.util.Log;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Result {
    private String ID;
    private String name;
    private String company;
    private String size;
    private int cost;

//    public Result(String id, String name, String company, String size, int cost) {
//        this.ID = id;
//        this.name = name;
//        this.company = company;
//        this.size = size;
//        this.cost = cost;
//    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getSize() {
        int number = Integer.parseInt(size);
        String temp = Integer.toString(number);
        int[] numbers = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            numbers[i] = temp.charAt(i) - '0';
        }

        return numbers[0] + ":" + numbers[1] + numbers[2] + ":" + numbers[3] + numbers[4];
    }

    public int getCost() {
        return cost;
    }
}
