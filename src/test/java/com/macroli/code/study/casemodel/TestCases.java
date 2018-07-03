package com.macroli.code.study.casemodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.List;


public class TestCases {

    private List<Case> case_path;

    public List<Case> getCase_path() {
        return case_path;
    }

    public void setCase_path(List<Case> case_path) {
        this.case_path = case_path;
    }
}
