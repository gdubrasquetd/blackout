package fr.guillaume.BlackOut;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Activity {
    static final AlphaAnimation buttonClick = new AlphaAnimation(0.5F, 0.7F);
    static List<Integer> EVENT_TYPE = new ArrayList<Integer>();
    static boolean Duel = true;
    static boolean Tournee = true;
    static boolean MiniJeu = true;
    static boolean Dilem = true;
    static boolean Role = true;
    static int count = 0;
    static boolean nouveau = false;
    static Game game = new Game(1);
    static int EVENT_PROBA = 25;
    static int limite = 0;
    static List<String> tmp = new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        if (Duel) {
            if (!EVENT_TYPE.contains(Integer.valueOf(1))) EVENT_TYPE.add(Integer.valueOf(1));
        } else {
            EVENT_TYPE.remove(Integer.valueOf(1));
        }

        if (MiniJeu) {
            if (!EVENT_TYPE.contains(Integer.valueOf(0))) EVENT_TYPE.add(Integer.valueOf(0));
        } else {
            EVENT_TYPE.remove(Integer.valueOf(0));
        }

        if (Tournee) {
            if (!EVENT_TYPE.contains(Integer.valueOf(2))) EVENT_TYPE.add(Integer.valueOf(2));
        } else {
            EVENT_TYPE.remove(Integer.valueOf(2));
        }

        if (Dilem) {
            if (!EVENT_TYPE.contains(Integer.valueOf(3))) EVENT_TYPE.add(Integer.valueOf(3));
        } else {
            EVENT_TYPE.remove(Integer.valueOf(3));
        }
        if (Role) {
            if (!EVENT_TYPE.contains(Integer.valueOf(4))) EVENT_TYPE.add(Integer.valueOf(4));
        } else {
            EVENT_TYPE.remove(Integer.valueOf(4));
        }

        System.out.println(EVENT_TYPE);


        final Button jouer = findViewById(R.id.jouer);
        final Button shop = findViewById(R.id.shop);
        final Button parameter = findViewById(R.id.parameter);
        final Button personalize = findViewById(R.id.personalize);

        buttonClick.setDuration(350);

        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (game.getID() == 1) {
                    Intent myIntent = new Intent(HomePage.this, PlayerPage.class);
                    startActivity(myIntent);
                } else {
                    alertDialog();
                }
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent myIntent = new Intent(HomePage.this, ShopPage.class);
                startActivity(myIntent);
            }
        });

        parameter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent myIntent = new Intent(HomePage.this, ParameterPage.class);
                startActivity(myIntent);
            }
        });

        personalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent myIntent = new Intent(HomePage.this, PersonalizePage.class);
                startActivity(myIntent);
            }
        });
    }

    private void alertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        dialog.setMessage("Souhaitez vous reprendre ou modifier la partie en cours ?");
        dialog.setTitle("Lancer une partie");
        dialog.setPositiveButton("Oui",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        nouveau = true;
                        Intent myIntent = new Intent(HomePage.this, PlayerPage.class);
                        startActivity(myIntent);
                    }
                });
        dialog.setNegativeButton("Nouvelle partie",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        nouveau = false;
                        Intent myIntent = new Intent(HomePage.this, PlayerPage.class);
                        startActivity(myIntent);
                    }
                });
        AlertDialog alert = dialog.create();
        alert.show();
    }

}