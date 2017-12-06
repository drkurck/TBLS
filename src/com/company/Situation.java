package com.company;

public class Situation {
    private State current;
    private State next;

    public Situation(State current, State next) {
        this.current = current;
        this.next = next;
    }
    static public double computeOutcome(Situation s) {
        double health = s.next.getHealth() - s.current.getHealth();
        double maturity = s.next.getMaturity() - s.current.getMaturity();
        double socialisation = s.next.getSocialisation() - s.current.getSocialisation();

        return health+maturity+socialisation;
    }

    @Override
    public String toString() {
        return "Situation{" +
                "current=" + current.toString() +
                ", next=" + next.toString() +
                '}';
    }

    public State getCurrent() {
        return current;
    }

    public void setCurrent(State current) {
        this.current = current;
    }

    public State getNext() {
        return next;
    }

    public void setNext(State next) {
        this.next = next;
    }

}
