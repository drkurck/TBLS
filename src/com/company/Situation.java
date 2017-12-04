package com.company;

public class Situation {
    private State current;
    private State previous;

    public Situation(State current, State previous) {
        this.current = current;
        this.previous = previous;
    }

    public State getCurrent() {
        return current;
    }

    public void setCurrent(State current) {
        this.current = current;
    }

    public State getPrevious() {
        return previous;
    }

    public void setPrevious(State previous) {
        this.previous = previous;
    }
}
