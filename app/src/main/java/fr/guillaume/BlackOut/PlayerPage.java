package fr.guillaume.BlackOut;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.io.InputStream;

import static fr.guillaume.BlackOut.HomePage.EVENT_TYPE;
import static fr.guillaume.BlackOut.HomePage.buttonClick;
import static fr.guillaume.BlackOut.HomePage.game;
import static fr.guillaume.BlackOut.HomePage.nouveau;


public class PlayerPage extends Activity {
    private Player player1, player2, player3, player4, player5, player6, player7, player8, player9, player10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playerpage);

        System.out.println(EVENT_TYPE);

        final ScrollView scrollView2 = findViewById(R.id.scrollView2);

        final Button add1 = findViewById(R.id.add1);
        final Button add2 = findViewById(R.id.add2);
        final Button add3 = findViewById(R.id.add3);
        final Button add4 = findViewById(R.id.add4);
        final Button add5 = findViewById(R.id.add5);
        final Button add6 = findViewById(R.id.add6);
        final Button add7 = findViewById(R.id.add7);
        final Button add8 = findViewById(R.id.add8);

        final ScrollView scroll = findViewById(R.id.scrollView2);

        final Button jouer = findViewById(R.id.jouer);

        final EditText Player1 = findViewById(R.id.textplayer1);
        final EditText Player2 = findViewById(R.id.textplayer2);
        final EditText Player3 = findViewById(R.id.textplayer3);
        final EditText Player4 = findViewById(R.id.textplayer4);
        final EditText Player5 = findViewById(R.id.textplayer5);
        final EditText Player6 = findViewById(R.id.textplayer6);
        final EditText Player7 = findViewById(R.id.textplayer7);
        final EditText Player8 = findViewById(R.id.textplayer8);
        final EditText Player9 = findViewById(R.id.textplayer9);
        final EditText Player10 = findViewById(R.id.textplayer10);

        final ToggleButton genre1 = findViewById(R.id.genre1);
        final ToggleButton genre2 = findViewById(R.id.genre2);
        final ToggleButton genre3 = findViewById(R.id.genre3);
        final ToggleButton genre4 = findViewById(R.id.genre4);
        final ToggleButton genre5 = findViewById(R.id.genre5);
        final ToggleButton genre6 = findViewById(R.id.genre6);
        final ToggleButton genre7 = findViewById(R.id.genre7);
        final ToggleButton genre8 = findViewById(R.id.genre8);
        final ToggleButton genre9 = findViewById(R.id.genre9);
        final ToggleButton genre10 = findViewById(R.id.genre10);


        if (nouveau) {

            if (game.getPlayerList().size() >= 1) {
                Player1.setText(game.getPlayerList().get(0).getName());
                genre1.setChecked(game.getPlayerList().get(0).isGenre());
            }
            if (game.getPlayerList().size() >= 2) {
                Player2.setText(game.getPlayerList().get(1).getName());
                genre2.setChecked(game.getPlayerList().get(1).isGenre());
            }
            if (game.getPlayerList().size() >= 3) {
                System.out.println("ça marche ?");
                add1.setVisibility(View.INVISIBLE);
                Player3.setVisibility(View.VISIBLE);
                genre3.setVisibility(View.VISIBLE);
                genre3.setChecked(game.getPlayerList().get(2).isGenre());
                add2.setVisibility(View.VISIBLE);
                Player3.setText(game.getPlayerList().get(2).getName());
            }
            if (game.getPlayerList().size() >= 4) {
                add2.setVisibility(View.INVISIBLE);
                Player4.setVisibility(View.VISIBLE);
                genre4.setVisibility(View.VISIBLE);
                genre4.setChecked(game.getPlayerList().get(3).isGenre());
                add3.setVisibility(View.VISIBLE);
                Player4.setText(game.getPlayerList().get(3).getName());
            }
            if (game.getPlayerList().size() >= 5) {
                add3.setVisibility(View.INVISIBLE);
                Player5.setVisibility(View.VISIBLE);
                genre5.setVisibility(View.VISIBLE);
                genre5.setChecked(game.getPlayerList().get(4).isGenre());
                add4.setVisibility(View.VISIBLE);
                Player5.setText(game.getPlayerList().get(4).getName());
            }
            if (game.getPlayerList().size() >= 6) {
                add4.setVisibility(View.INVISIBLE);
                Player6.setVisibility(View.VISIBLE);
                genre6.setVisibility(View.VISIBLE);
                genre6.setChecked(game.getPlayerList().get(5).isGenre());
                add5.setVisibility(View.VISIBLE);
                Player6.setText(game.getPlayerList().get(5).getName());
            }
            if (game.getPlayerList().size() >= 7) {
                add5.setVisibility(View.INVISIBLE);
                Player7.setVisibility(View.VISIBLE);
                genre7.setVisibility(View.VISIBLE);
                genre7.setChecked(game.getPlayerList().get(6).isGenre());
                add6.setVisibility(View.VISIBLE);
                Player7.setText(game.getPlayerList().get(6).getName());
            }
            if (game.getPlayerList().size() >= 8) {
                add6.setVisibility(View.INVISIBLE);
                Player8.setVisibility(View.VISIBLE);
                genre8.setVisibility(View.VISIBLE);
                genre8.setChecked(game.getPlayerList().get(7).isGenre());
                add7.setVisibility(View.VISIBLE);
                Player8.setText(game.getPlayerList().get(7).getName());
            }
            if (game.getPlayerList().size() >= 9) {
                add7.setVisibility(View.INVISIBLE);
                Player9.setVisibility(View.VISIBLE);
                genre9.setVisibility(View.VISIBLE);
                genre9.setChecked(game.getPlayerList().get(8).isGenre());
                add8.setVisibility(View.VISIBLE);
                Player9.setText(game.getPlayerList().get(8).getName());
            }
            if (game.getPlayerList().size() >= 10) {
                add8.setVisibility(View.INVISIBLE);
                Player10.setVisibility(View.VISIBLE);
                genre10.setVisibility(View.VISIBLE);
                genre10.setChecked(game.getPlayerList().get(9).isGenre());
                Player10.setText(game.getPlayerList().get(9).getName());
            }
        }


        //Ajouter des joueurs

        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add1.setVisibility(View.INVISIBLE);
                Player3.setVisibility(View.VISIBLE);
                genre3.setVisibility(View.VISIBLE);
                add2.setVisibility(View.VISIBLE);
                scrollView2.post(new Runnable() {
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add2.setVisibility(View.INVISIBLE);
                Player4.setVisibility(View.VISIBLE);
                genre4.setVisibility(View.VISIBLE);
                add3.setVisibility(View.VISIBLE);
                scrollView2.post(new Runnable() {
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });

        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add3.setVisibility(View.INVISIBLE);
                Player5.setVisibility(View.VISIBLE);
                genre5.setVisibility(View.VISIBLE);
                add4.setVisibility(View.VISIBLE);
                scrollView2.post(new Runnable() {
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });

        add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add4.setVisibility(View.INVISIBLE);
                Player6.setVisibility(View.VISIBLE);
                genre6.setVisibility(View.VISIBLE);
                add5.setVisibility(View.VISIBLE);
                scrollView2.post(new Runnable() {
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });

        add5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add5.setVisibility(View.INVISIBLE);
                Player7.setVisibility(View.VISIBLE);
                genre7.setVisibility(View.VISIBLE);
                add6.setVisibility(View.VISIBLE);
                scrollView2.post(new Runnable() {
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });

        add6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add6.setVisibility(View.INVISIBLE);
                Player8.setVisibility(View.VISIBLE);
                genre8.setVisibility(View.VISIBLE);
                add7.setVisibility(View.VISIBLE);
                scrollView2.post(new Runnable() {
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });

        add7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add7.setVisibility(View.INVISIBLE);
                Player9.setVisibility(View.VISIBLE);
                genre9.setVisibility(View.VISIBLE);
                add8.setVisibility(View.VISIBLE);
                scrollView2.post(new Runnable() {
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });

        add8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add8.setVisibility(View.INVISIBLE);
                Player10.setVisibility(View.VISIBLE);
                genre10.setVisibility(View.VISIBLE);
                scrollView2.post(new Runnable() {
                    public void run() {
                        scrollView2.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });

        //Lancer le jeu

        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (Player1.getText().toString().matches("") || Player2.getText().toString().matches("")) {
                    alertDialog();
                } else {
                    HomePage.game = new Game(2);

                    game.clear();

                    player1 = new Player(Player1.getText());
                    player2 = new Player(Player2.getText());
                    player3 = new Player(Player3.getText());
                    player4 = new Player(Player4.getText());
                    player5 = new Player(Player5.getText());
                    player6 = new Player(Player6.getText());
                    player7 = new Player(Player7.getText());
                    player8 = new Player(Player8.getText());
                    player9 = new Player(Player9.getText());
                    player10 = new Player(Player10.getText());

                    player1.setGenre(genre1.isChecked());
                    player2.setGenre(genre2.isChecked());
                    player3.setGenre(genre3.isChecked());
                    player4.setGenre(genre4.isChecked());
                    player5.setGenre(genre5.isChecked());
                    player6.setGenre(genre6.isChecked());
                    player7.setGenre(genre7.isChecked());
                    player8.setGenre(genre8.isChecked());
                    player9.setGenre(genre9.isChecked());
                    player10.setGenre(genre10.isChecked());


                    HomePage.game.addPlayers(player1);
                    HomePage.game.addPlayers(player2);
                    HomePage.game.addPlayers(player3);
                    HomePage.game.addPlayers(player4);
                    HomePage.game.addPlayers(player5);
                    HomePage.game.addPlayers(player6);
                    HomePage.game.addPlayers(player7);
                    HomePage.game.addPlayers(player8);
                    HomePage.game.addPlayers(player9);
                    HomePage.game.addPlayers(player10);


                    try {
                        InputStream transitionFStream = getAssets().open("transitionFemme.json");
                        HomePage.game.fillJson(transitionFStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        InputStream transitionHStream = getAssets().open("transitionHomme.json");
                        HomePage.game.fillJson(transitionHStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        InputStream duelStream = getAssets().open("duel.json");
                        HomePage.game.fillJson(duelStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        InputStream globalStream = getAssets().open("global.json");
                        HomePage.game.fillJson(globalStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    try {
                        InputStream minijeuStream = getAssets().open("miniJeu.json");
                        HomePage.game.fillJson(minijeuStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        InputStream dilemStream = getAssets().open("dilem.json");
                        HomePage.game.fillJson(dilemStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        InputStream roleStream = getAssets().open("role.json");
                        HomePage.game.fillJson(roleStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Intent myIntent = new Intent(PlayerPage.this, ModePage.class);
                    startActivity(myIntent);
                    finish();
                }
            }
        });

    }


    private void refreshPlayer(EditText e, Player p) {

    }


    private void alertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        dialog.setMessage("Il faut au moins 2 joueurs pour commencer une partie");
        dialog.setTitle("Pas assez de joueur");
        dialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
                    }
                });

        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
}
