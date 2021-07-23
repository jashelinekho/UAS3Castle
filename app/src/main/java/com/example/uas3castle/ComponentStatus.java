package com.example.uas3castle;

public class ComponentStatus {
    private String description = "status for Atk & Def";
    protected double atkToInfantry;
    protected double atkToArcher;
    protected double atkToCavalry;
    protected double atkToCatapult;

    public ComponentStatus(double j, double k, double l, double m) {
        // TODO Auto-generated constructor stub
        this.atkToInfantry = j;
        this.atkToArcher = k;
        this.atkToCavalry = l;
        this.atkToCatapult = m;
    }

    public double getAtkToInfantry() {
        return atkToInfantry;
    }

    public void setAtkToInfantry(double atkToInfantry) {
        this.atkToInfantry = atkToInfantry;
    }

    public double getAtkToArcher() {
        return atkToArcher;
    }

    public void setAtkToArcher(double atkToArcher) {
        this.atkToArcher = atkToArcher;
    }

    public double getAtkToCavalry() {
        return atkToCavalry;
    }

    public void setAtkToCavalry(double atkToCavalry) {
        this.atkToCavalry = atkToCavalry;
    }

    public double getAtkToCatapult() {
        return atkToCatapult;
    }

    public void setAtkToCatapult(double atkToCatapult) {
        this.atkToCatapult = atkToCatapult;
    }
}
