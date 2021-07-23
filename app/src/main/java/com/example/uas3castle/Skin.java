package com.example.uas3castle;

public class Skin {
    public Skin() {};

    public Skin(String string, String string2) {
        // TODO Auto-generated constructor stub
        this.skinName = string;
        this.boostTo = string2;
    }
    private String skinName;
    private String boostTo;
    private final int boostPercent = 40;

    public String getSkinName() {
        return skinName;
    }
    public String getBoostTo() {
        return boostTo;
    }
    public int getBoostPercent() {
        return boostPercent;
    }
}
