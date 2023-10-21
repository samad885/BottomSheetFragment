package com.example.myapplication;

public class Model {
    String f_name, name;

    public Model(String f_name, String name) {
        this.f_name = f_name;
        this.name = name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
