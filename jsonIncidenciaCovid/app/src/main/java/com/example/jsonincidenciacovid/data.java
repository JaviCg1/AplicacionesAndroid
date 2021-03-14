package com.example.jsonincidenciacovid;

import java.util.List;

public class data {
    private List<Incidencia> data;

    public List<Incidencia> getData() {
        return data;
    }

    public void setData(List<Incidencia> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data{" +
                "data=" + data +
                '}';
    }
}
