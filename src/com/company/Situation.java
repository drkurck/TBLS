package com.company;

public class Situation {
    private State current;
    private State previous;

    public Situation(State current, State previous) {
        this.current = current;
        this.previous = previous;
    }
    static public double computeOutcome(Situation s) {
        double health = s.current.getHealth() - s.getPrevious().getHealth();
        double maturity = s.current.getMaturity() - s.getPrevious().getMaturity();
        double socialisation = s.current.getSocialisation() - s.getPrevious().getSocialisation();

        return health+maturity+socialisation;
    }

    @Override
    public String toString() {
        return "Situation{" +
                "current=" + current.toString() +
                ", previous=" + previous.toString() +
                '}';
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
