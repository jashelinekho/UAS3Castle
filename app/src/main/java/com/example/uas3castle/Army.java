package com.example.uas3castle;

public class Army extends ComponentStatus{
    public Army(String string, double j, double k, double l, double m) {
        super(j, k, l, m);
        // TODO Auto-generated constructor stub
        this.name = string;
        this.armySize = 0;
        this.setAtkToArcher(j);
        this.setAtkToCatapult(k);
        this.setAtkToCavalry(l);
        this.setAtkToInfantry(m);
    }

    protected String name;
    private int armySize;

    public String getName() {
        return name;
    }

    public int getArmySize() {
        return armySize;
    }

    public void setArmySize(int armySize) {
        this.armySize = armySize;
    }
}
