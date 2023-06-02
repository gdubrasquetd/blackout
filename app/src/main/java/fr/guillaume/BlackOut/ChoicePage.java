package fr.guillaume.BlackOut;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class ChoicePage extends Activity {
    static String random;
    static String boy;
    static String girl;
    static String opposite;
    static String same;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choicepage);

        final TextView playername = findViewById(R.id.playername);
        final TextView transition = findViewById(R.id.transition);
        final Random rand = new Random();

        final Button action = findViewById(R.id.action);
        final Button verite = findViewById(R.id.verite);
        final Button random = findViewById(R.id.random);
        final Button menu = findViewById(R.id.menu);

        Player actualPlayer = HomePage.game.getRandomPlayer();

        playername.setText(actualPlayer.toString());
        transition.setText(HomePage.game.getTransition());

        HomePage.count++;
        // System.out.println(HomePage.count);

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ChoicePage.this, ActionPage.class);
                startActivity(myIntent);
                finish();
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ChoicePage.this, HomePage.class);
                startActivity(myIntent);
                finish();
            }
        });

        verite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ChoicePage.this, VeritePage.class);
                startActivity(myIntent);
                finish();
            }
        });

        if (rand.nextBoolean()) {
            random.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(ChoicePage.this, VeritePage.class);
                    startActivity(myIntent);
                    finish();
                }
            });
        } else {
            random.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(ChoicePage.this, ActionPage.class);
                    startActivity(myIntent);
                    finish();
                }
            });
        }
    }
  /*  public void finish() {
        super.finish();
        overridePendingTransition(R.anim.begin_event_transition, R.anim.end_event_transition);
    }*/
}