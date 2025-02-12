package com.example.newtest.enity;

import lombok.Data;

@Data
public class AddParam {
    private int id;
    private boolean addRow;
    private String date;
    private double surplusHours;
    private double outputQuantityHours;
    private double professionalHours;
    private double textHours;
}
