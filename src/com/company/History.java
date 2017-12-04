package com.company;


import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Situation> historySituation;

    public History() {
        this.historySituation = new ArrayList<Situation>();
    }

    public void addElement(Situation s) {
        this.historySituation.add(s);
    }

    public List<Situation> getHistorySituation() {
        return historySituation;
    }

    public void setHistorySituation(List<Situation> historySituation) {
        this.historySituation = historySituation;
    }
}
