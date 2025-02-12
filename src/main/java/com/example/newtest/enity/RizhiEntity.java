package com.example.newtest.enity;

import lombok.Data;

@Data
public class RizhiEntity {
    private int id;
    private boolean addRow;
    private String date;
    private int outputQuantityHours;
    private int professionalHours;
    private String projectId;
    private String subId;
    private String dsubId;
}
