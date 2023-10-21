package com.example.myapplication;

public class ChildModel {
    String pro_Num, pro_name, code, output;
    public ChildModel(String pro_Num, String pro_name, String code, String output) {
        this.pro_Num = pro_Num;
        this.pro_name = pro_name;
        this.code = code;
        this.output = output;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getPro_Num() {
        return pro_Num;
    }

    public void setPro_Num(String pro_Num) {
        this.pro_Num = pro_Num;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }
}
