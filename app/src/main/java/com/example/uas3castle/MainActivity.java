package com.example.uas3castle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView castle1;
    ImageView castle2;
    ImageView knight1;
    ImageView knight2;
    ImageView vs;
    ImageView win1;
    ImageView win2;
    Button button1;
    Button button2;
    TextView battleSumm;
    protected ArrayList<Skin> ALskin =  new ArrayList<Skin>();
    protected ArrayList<Heroes> ALheroes =  new ArrayList<Heroes>();
    protected ArrayList<Army> ALarmy =  new ArrayList<Army>();
    static player player1;
    static player player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        castle1 = findViewById(R.id.castle1);
        castle2 = findViewById(R.id.castle2);
        knight1 = findViewById(R.id.knight1);
        knight2 = findViewById(R.id.knight2);
        vs = findViewById(R.id.vs);
        win1 = findViewById(R.id.win1);
        win2 = findViewById(R.id.win2);

        win1.setVisibility(View.INVISIBLE);
        win2.setVisibility(View.INVISIBLE);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        battleSumm = findViewById(R.id.battleSumm);
        battleSumm.setVisibility(View.INVISIBLE);
        battleSumm.setSingleLine(false);

        initComponent(ALarmy, ALheroes, ALskin);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    private static void initComponent(ArrayList<Army> ALArmy, ArrayList<Heroes> ALHeroes, ArrayList<Skin> ALSkin) {
        // TODO Auto-generated method stub
        // initGame component
        Army army1 = new Army("Infantry", 0.4, 0.0, 0.1, 0.0);
        Army army2 = new Army("Archer", 0.0, 0.0, 0.4, 0.1);
        Army army3 = new Army("Cavalry", 0.1, 0.0, 0.0, 0.4);
        Army army4 = new Army("Catapult", 0.0, 0.0, 0.0, 0.0);
        ALArmy.add(army1);ALArmy.add(army2);ALArmy.add(army3);ALArmy.add(army4);

        Heroes hero1 = new Heroes("Infantry Hero", army1.name, 0);
        Heroes hero2 = new Heroes("Archer Hero", army2.name, 0);
        Heroes hero3 = new Heroes("Cavalry Hero", army3.name, 0);
        Heroes hero4 = new Heroes("Catapult Hero", army4.name, 0);
        ALHeroes.add(hero1);ALHeroes.add(hero2);ALHeroes.add(hero3);ALHeroes.add(hero4);

        Skin skin3 = new Skin("Steel", army1.name);
        Skin skin1 = new Skin("Horse", army2.name);
        Skin skin2 = new Skin("Wood", army3.name);
        Skin skin4 = new Skin("Stone", army4.name);
        ALSkin.add(skin1);ALSkin.add(skin2);ALSkin.add(skin3);ALSkin.add(skin4);
    }

    @Override
    public void onClick(View v) {
        player1 = new player();
        player2 = new player();

        if(v.getId() == R.id.button1){
            initgame1(player1, player2);
            initbattle(player1, player2);
        }
        else if(v.getId() == R.id.button2){
            initgame2(player1, player2);
            initbattle(player1, player2);
        }
    }

    private void initgame1(player player1, player player2) {
        player1.assignArmy(this.ALarmy.get(2));
        player1.getALArmy().get(0).setArmySize(100000);
        player2.assignArmy(this.ALarmy.get(0));
        player2.getALArmy().get(0).setArmySize(100000);
        int tempRand = 0;

        tempRand = new Random().nextInt((5 - 1) + 1) + 1;
        for(int i=0; i < tempRand-1; i++){
            tempRand = new Random().nextInt((4 - 1) + 1) + 1;
            player1.assignHero(ALheroes.get(tempRand-1));
        }
        tempRand = new Random().nextInt((5 - 1) + 1) + 1;
        for(int i=0; i < tempRand-1; i++){
            tempRand = new Random().nextInt((4 - 1) + 1) + 1;
            player2.assignHero(ALheroes.get(tempRand-1));
        }

        tempRand = new Random().nextInt((4 - 1) + 1) + 1;
        player1.assignSkin(ALskin.get(tempRand-1));
        tempRand = new Random().nextInt((4 - 1) + 1) + 1;
        player2.assignSkin(ALskin.get(tempRand-1));
        Log.i("Skin1", player1.getSkin().getSkinName());
        Log.i("Skin1 Boost", player1.getSkin().getBoostTo());
        Log.i("Skin2", player2.getSkin().getSkinName());
        Log.i("Skin2 Boost", player2.getSkin().getBoostTo());

        for (int i=0; i< player1.getALHero().size(); i++){
            Log.i("Hero1", player1.getALHero().get(i).getName());
            Log.i("Hero1 Boost", player1.getALHero().get(i).getBoostTo());
        }

        for (int i=0; i< player2.getALHero().size(); i++){
            Log.i("Hero2", player2.getALHero().get(i).getName());
            Log.i("Hero2 Boost", player2.getALHero().get(i).getBoostTo());
        }
    }

    private void initgame2(player player1, player player2) {
        int tempRand = 0;
        player1.assignArmy(this.ALarmy.get(0));
        player1.getALArmy().get(0).setArmySize(100000);
        player2.assignArmy(this.ALarmy.get(2));
        player2.getALArmy().get(0).setArmySize(new Random().nextInt((100000 - 1) + 1) + 1);

        do{
            tempRand = new Random().nextInt((4 - 1) + 1) + 1;
        }while(ALarmy.get(tempRand-1).getName().contains("Infantry") || ALarmy.get(tempRand-1).getName().contains("Cavalry"));
        player2.assignArmy(this.ALarmy.get(tempRand-1));
        player2.getALArmy().get(1).setArmySize(100000 - player2.getALArmy().get(0).getArmySize());

        tempRand = new Random().nextInt((5 - 1) + 1) + 1;
        for(int i=0; i < tempRand-1; i++){
            tempRand = new Random().nextInt((4 - 1) + 1) + 1;
            player1.assignHero(ALheroes.get(tempRand-1));
        }
        tempRand = new Random().nextInt((5 - 1) + 1) + 1;
        for(int i=0; i < tempRand-1; i++){
            tempRand = new Random().nextInt((4 - 1) + 1) + 1;
            player2.assignHero(ALheroes.get(tempRand-1));
        }

        tempRand = new Random().nextInt((4 - 1) + 1) + 1;
        player1.assignSkin(ALskin.get(tempRand-1));
        tempRand = new Random().nextInt((4 - 1) + 1) + 1;
        player2.assignSkin(ALskin.get(tempRand-1));
        Log.i("Skin1", player1.getSkin().getSkinName());
        Log.i("Skin1 Boost", player1.getSkin().getBoostTo());
        Log.i("Skin2", player2.getSkin().getSkinName());
        Log.i("Skin2 Boost", player2.getSkin().getBoostTo());

        for (int i=0; i< player1.getALHero().size(); i++){
            Log.i("Hero1", player1.getALHero().get(i).getName());
            Log.i("Hero1 Boost", player1.getALHero().get(i).getBoostTo());
        }

        for (int i=0; i< player2.getALHero().size(); i++){
            Log.i("Hero2", player2.getALHero().get(i).getName());
            Log.i("Hero2 Boost", player2.getALHero().get(i).getBoostTo());
        }
    }

    private void initbattle(player player1, player player2) {
        int player1Cas = 0;
        int player2Cas = 0;
        int totalPowerArmy1 = 0;
        int totalPowerArmy2 = 0;
        int totalArmy1= 0;
        int totalArmy2= 0;

        for(int k=0; k< player1.getALArmy().size(); k++){
            totalArmy1 += player1.getALArmy().get(k).getArmySize();
        }

        for(int k=0; k< player1.getALHero().size(); k++) {
            for (int n = 0; n < player1.getALArmy().size(); n++) {
                if (player1.getALHero().get(k).getName().contains("Archer") && player1.getALArmy().get(n).getName().contains("Archer"))
                    totalPowerArmy1 += (player1.getALHero().get(k).getBoostPercent() * (player1.getALArmy().get(n).getArmySize())) /100;
                else if (player1.getALHero().get(k).getName().contains("Cavalry") && player1.getALArmy().get(n).getName().contains("Cavalry"))
                    totalPowerArmy1 += (player1.getALHero().get(k).getBoostPercent() * (player1.getALArmy().get(n).getArmySize())) /100;
                else if (player1.getALHero().get(k).getName().contains("Infantry") && player1.getALArmy().get(n).getName().contains("Infantry"))
                    totalPowerArmy1 += (player1.getALHero().get(k).getBoostPercent() * (player1.getALArmy().get(n).getArmySize())) /100;
                else if (player1.getALHero().get(k).getName().contains("Catapult") && player1.getALArmy().get(n).getName().contains("Catapult"))
                    totalPowerArmy1 += (player1.getALHero().get(k).getBoostPercent() * (player1.getALArmy().get(n).getArmySize())) /100;
                Log.i("Total1SUB", String.valueOf(totalPowerArmy1));
            }
        }
        totalPowerArmy1 += 100000;
        Log.i("Total1", String.valueOf(totalPowerArmy1));

        for(int m=0; m< player2.getALArmy().size(); m++) {
            totalArmy2 += player2.getALArmy().get(m).getArmySize();
        }

        for(int k=0; k< player2.getALHero().size(); k++) {
            for (int n = 0; n < player2.getALArmy().size(); n++) {
                if (player2.getALHero().get(k).getName().contains("Archer") && player2.getALArmy().get(n).getName().contains("Archer"))
                    totalPowerArmy2 += (player2.getALHero().get(k).getBoostPercent() * (player2.getALArmy().get(n).getArmySize())) /100;
                else if (player2.getALHero().get(k).getName().contains("Cavalry") && player2.getALArmy().get(n).getName().contains("Cavalry"))
                    totalPowerArmy2 += (player2.getALHero().get(k).getBoostPercent() * (player2.getALArmy().get(n).getArmySize())) /100;
                else if (player2.getALHero().get(k).getName().contains("Infantry") && player2.getALArmy().get(n).getName().contains("Infantry"))
                    totalPowerArmy2 += (player2.getALHero().get(k).getBoostPercent() * (player2.getALArmy().get(n).getArmySize())) /100;
                else if (player2.getALHero().get(k).getName().contains("Catapult") && player2.getALArmy().get(n).getName().contains("Catapult"))
                    totalPowerArmy2 += (player2.getALHero().get(k).getBoostPercent() * (player2.getALArmy().get(n).getArmySize())) /100;
            }
        }
        totalPowerArmy2 += 100000;
        Log.i("Total2", String.valueOf(totalPowerArmy2));

        for(int i=0; i< player1.getALArmy().size(); i++){
            for(int j=0; j<player2.getALArmy().size(); j++) {
                switch (player2.getALArmy().get(j).getName()) {
                    case "Archer" :
                        //player2Cas += (player1.getALArmy().get(i).getArmySize() + (player1.getALArmy().get(i).getArmySize() * player1.getALArmy().get(i).getAtkToArcher()));
                        player2Cas += (player1.getALArmy().get(i).getArmySize() * player1.getALArmy().get(i).getAtkToArcher());
                    case "Cavalry" :
                        //player2Cas += (player1.getALArmy().get(i).getArmySize() + (player1.getALArmy().get(i).getArmySize() * player1.getALArmy().get(i).getAtkToCavalry()));
                        player2Cas += (player1.getALArmy().get(i).getArmySize() * player1.getALArmy().get(i).getAtkToCavalry());
                    case "Infantry" :
                        //player2Cas += (player1.getALArmy().get(i).getArmySize() + (player1.getALArmy().get(i).getArmySize() * player1.getALArmy().get(i).getAtkToInfantry()));
                        player2Cas += (player1.getALArmy().get(i).getArmySize() * player1.getALArmy().get(i).getAtkToInfantry());
                    case "Catapult" :
                        //player2Cas += (player1.getALArmy().get(i).getArmySize() + (player1.getALArmy().get(i).getArmySize() * player1.getALArmy().get(i).getAtkToCatapult()));
                        player2Cas += (player1.getALArmy().get(i).getArmySize() * player1.getALArmy().get(i).getAtkToCatapult());
                }
            }
        }

        for(int i=0; i< player2.getALArmy().size(); i++){
            for(int j=0; j<player1.getALArmy().size(); j++) {
                switch (player1.getALArmy().get(j).getName()) {
                    case "Archer" :
                        //player1Cas += (player2.getALArmy().get(i).getArmySize() + (player2.getALArmy().get(i).getArmySize() * player2.getALArmy().get(i).getAtkToArcher()));
                        player1Cas += (player2.getALArmy().get(i).getArmySize() * player2.getALArmy().get(i).getAtkToArcher());
                    case "Cavalry" :
                        //player1Cas += (player2.getALArmy().get(i).getArmySize() + (player2.getALArmy().get(i).getArmySize() * player2.getALArmy().get(i).getAtkToCavalry()));
                        player1Cas += (player2.getALArmy().get(i).getArmySize() * player2.getALArmy().get(i).getAtkToCavalry());
                    case "Infantry" :
                        //player1Cas += (player2.getALArmy().get(i).getArmySize() + (player2.getALArmy().get(i).getArmySize() * player2.getALArmy().get(i).getAtkToInfantry()));
                        player1Cas += (player2.getALArmy().get(i).getArmySize() * player2.getALArmy().get(i).getAtkToInfantry());
                    case "Catapult" :
                        //player1Cas += (player2.getALArmy().get(i).getArmySize() + (player2.getALArmy().get(i).getArmySize() * player2.getALArmy().get(i).getAtkToCatapult()));
                        player1Cas += (player2.getALArmy().get(i).getArmySize() * player2.getALArmy().get(i).getAtkToCatapult());
                }
            }
        }

        if(totalArmy1 - player1Cas > totalArmy2 - player2Cas) {
            win1.setVisibility(View.VISIBLE);
            win2.setVisibility(View.INVISIBLE);
        }
        else {
            win2.setVisibility(View.VISIBLE);
            win1.setVisibility(View.INVISIBLE);
        }
        battleSumm.setText("Casualties Player 1 " +player1Cas +", Casualties Player 2 " +player2Cas +"\n"+  " Player1 Army left" +(totalArmy1 - player1Cas) +", Player2 Army left" +(totalArmy2 - player2Cas)  +"\n"+" Total Power 1 " +totalPowerArmy1 +" Total Power 2 " +totalPowerArmy2 );
        battleSumm.setVisibility(View.VISIBLE);
    }
}
