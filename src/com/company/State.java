package com.company;

public class State {
    private String name;
    private float health;
    private float socialisation;
    private float maturity;

    public State(String name, float health, float socialisation, float maturity) {
        this.name = name;
        this.health = health;
        this.socialisation = socialisation;
        this.maturity = maturity;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", socialisation=" + socialisation +
                ", maturity=" + maturity +
                '}';
    }

    public State(String name) {
        this.name = name;
        this.health = 0;
        this.socialisation = 0;
        this.maturity = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getSocialisation() {
        return socialisation;
    }

    public void setSocialisation(float socialisation) {
        this.socialisation = socialisation;
    }

    public float getMaturity() {
        return maturity;
    }

    public void setMaturity(float maturity) {
        this.maturity = maturity;
    }
}
