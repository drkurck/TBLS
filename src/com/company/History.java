package com.company;


import java.util.ArrayList;
import java.util.List;

/**
 * This Classe is used for trace based execution
 * Statistical evidence and TBSL
 */
public class History {
    private List<Situation> historySituation;
    private List<String> actionList;

    public History() {
        this.historySituation = new ArrayList<Situation>();
        this.actionList = new ArrayList<String>();
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

    public void addSituation(Situation s) {
        this.historySituation.add(s);
    }

    public void addAction(String action) {
        if (!actionList.contains(action)) {
            actionList.add(action);
        }
    }

    public List<Situation> getHistorySituation() {
        return historySituation;
    }

    public void setHistorySituation(List<Situation> historySituation) {
        this.historySituation = historySituation;
    }

    public List<String> getActionList() {
        return actionList;
    }

    public void setActionList(List<String> actionList) {
        this.actionList = actionList;
    }
}
