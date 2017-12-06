package com.company;


import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Situation> historySituation;

    public History() {
        this.historySituation = new ArrayList<Situation>();
    }

    public List<Situation> searchSimilarSituation(Situation search) {
        List<Situation> extracted = new ArrayList<Situation>();
        for (Situation s: this.historySituation) {
            if (s.getNext().getName().equals(search.getNext().getName()) &&
                    s.getCurrent().getName().equals(search.getCurrent().getName())) {
                extracted.add(s);
            }
        }

        return extracted;
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
