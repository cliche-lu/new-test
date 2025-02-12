package com.example.newtest.enity;

import lombok.Data;

import java.util.List;

@Data
public class RizhiNewEntity {
    private String projectId;
    private String subId;
    private String dsubId;
    private List<AddParam> addParams;
    private List<?> editParams;
}
