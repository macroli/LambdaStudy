package com.macroli.code.study.casemodel;

public class Case {
    private String case_name;

    public String getCase_name() {
        return case_name;
    }

    public void setCase_name(String case_name) {
        this.case_name = case_name;
    }

    public String getDownstream_mock_data() {
        return downstream_mock_data;
    }

    public void setDownstream_mock_data(String downstream_mock_data) {
        this.downstream_mock_data = downstream_mock_data;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    private String downstream_mock_data;
    private String expect;


}
