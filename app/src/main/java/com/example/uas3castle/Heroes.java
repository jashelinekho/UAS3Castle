package com.example.uas3castle;

public class Heroes{
    public Heroes(String string, String string2, int i) {
        // TODO Auto-generated constructor stub
        this.name = string;
        this.boostTo = string2;
        this.level = i;
    }

    private String name;
    private String boostTo;
    private final int boostPercent = 40;
    private int level;
    private final int levelMin = 1;
    private final int levelMax = 50;

    public String getName() {
        return name;
    }
    public String getBoostTo() {
        return boostTo;
    }
    public int getLevel() {
        return level;
    }
    public int getBoostPercent() {
        return boostPercent;
    }
    public int getLevelMin() {
        return levelMin;
    }
    public int getLevelMax() {
        return levelMax;
    }

}