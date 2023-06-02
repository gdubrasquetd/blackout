package fr.guillaume.BlackOut;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static fr.guillaume.BlackOut.HomePage.EVENT_PROBA;
import static fr.guillaume.BlackOut.HomePage.buttonClick;
import static fr.guillaume.BlackOut.HomePage.game;
import static fr.guillaume.BlackOut.HomePage.limite;

public class VeritePage extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veritepage);

        final TextView playername = findViewById(R.id.playername);
        final TextView veriteText = findViewById(R.id.veriteText);

        final Random rand = new Random();
        final int r = rand.nextInt(100);

        ChoicePage.random = HomePage.game.getRandomName();
        ChoicePage.boy = HomePage.game.getBoy();
        ChoicePage.girl = HomePage.game.getGirl();
        ChoicePage.opposite = HomePage.game.getLastPlayer().isGenre() ? ChoicePage.girl : ChoicePage.boy;
        ChoicePage.same = HomePage.game.getLastPlayer().isGenre() ? ChoicePage.boy : ChoicePage.girl;

        String tmp = HomePage.game.getVerite();

        System.out.println(tmp);

        veriteText.setText(String.format(tmp, ChoicePage.random, ChoicePage.opposite, ChoicePage.same, ChoicePage.boy, ChoicePage.girl));
        playername.setText(HomePage.game.getLastPlayer().toString());

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                //System.out.println("limite = "+ limite);
                if (r < EVENT_PROBA && limite > 2 && !HomePage.EVENT_TYPE.isEmpty()) {
                    limite = 1;
                    while (true) {
                        int r1 = HomePage.EVENT_TYPE.get(rand.nextInt(HomePage.EVENT_TYPE.size()));

                        if (!game.minijeuBool && !game.globalBool && !game.duelBool && !game.dilemBool && !game.roleBool) {
                            game.minijeuBool = true;
                            game.duelBool = true;
                            game.globalBool = true;
                            game.dilemBool = true;
                            game.roleBool = true;
                        }

                        if (r1 == 0 && game.minijeuBool) {
                            Intent myIntent = new Intent(VeritePage.this, TransitionMiniJeu.class);
                            startActivity(myIntent);
                            finish();
                            break;
                        }
                        if (r1 == 1 && game.duelBool) {
                            Intent myIntent = new Intent(VeritePage.this, TransitionDuel.class);
                            startActivity(myIntent);
                            finish();
                            break;
                        }
                        if (r1 == 2 && game.globalBool) {
                            Intent myIntent = new Intent(VeritePage.this, TransitionGlobal.class);
                            startActivity(myIntent);
                            finish();
                            break;
                        }
                        if (r1 == 3 && game.dilemBool) {
                            Intent myIntent = new Intent(VeritePage.this, TransitionDilem.class);
                            startActivity(myIntent);
                            finish();
                            break;
                        }
                        if (r1 == 4 && game.roleBool) {
                            Intent myIntent = new Intent(VeritePage.this, TransitionRole.class);
                            startActivity(myIntent);
                            finish();
                            break;
                        }
                    }
                } else {
                    Intent myIntent = new Intent(VeritePage.this, ChoicePage.class);
                    limite++;
                    startActivity(myIntent);
                    finish();
                }
            }
        });

        final Button menu = findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent myIntent = new Intent(VeritePage.this, HomePage.class);
                startActivity(myIntent);
                finish();
            }
        });
    }
}