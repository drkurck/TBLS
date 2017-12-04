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
