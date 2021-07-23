package com.example.uas3castle;

import android.util.Log;

import java.util.ArrayList;

public class player{
    private Skin skin;
    private ArrayList<Heroes> ALHero;
    private ArrayList<Army> ALArmy;

    public player(){
        this.skin = null;
        this.ALHero = new ArrayList<Heroes>();
        this.ALArmy = new ArrayList<Army>();
    }

    public void assignHero(Heroes hero) {
        // TODO Auto-generated method stub
        this.ALHero.add(hero);
    }

    public void assignArmy(Army army) {
        // TODO Auto-generated method stub
        this.ALArmy.add(army);
    }

    public void assignSkin(Skin skin) {
        // TODO Auto-generated method stub
        this.skin = skin;
        int baseArmy = 0;
        int bonusArmy = 0;

        /*for (int j = 0; j < ALArmy.size(); j++) {
            baseArmy = ALArmy.get(j).getArmySize();
            for (int i = 0; i < ALHero.size(); i++) {
                if (ALHero.get(i).getName().contains(ALArmy.get(j).getName()) == true) {
                    bonusArmy += baseArmy * ALHero.get(i).getBoostPercent() / 100;
                }
            }

            ALArmy.get(j).setArmySize(ALArmy.get(j).getArmySize()+ bonusArmy);

            if (this.skin.getBoostTo().contains(ALArmy.get(j).getName()) == true) {
                ALArmy.get(j).setArmySize(ALArmy.get(j).getArmySize()+ (baseArmy * this.skin.getBoostPercent() / 100));
                //ALArmy.get(j).setArmySize(ALArmy.get(j).getArmySize()+ (baseArmy * this.skin.getBoostPercent() / 100));
            }
        }*/
    }

    public Skin getSkin() {
        return skin;
    }

    public ArrayList<Heroes> getALHero() {
        return ALHero;
    }

    public ArrayList<Army> getALArmy() {
        return ALArmy;
    }
}