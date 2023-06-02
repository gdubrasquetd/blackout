package fr.guillaume.BlackOut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import static fr.guillaume.BlackOut.HomePage.EVENT_PROBA;
import static fr.guillaume.BlackOut.HomePage.buttonClick;

public class ParameterPage extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parameterpage);

        final SeekBar seek = findViewById(R.id.seekBar);
        final Button button = findViewById(R.id.button);
        final TextView text = findViewById(R.id.textView);
        final Button menu = findViewById(R.id.menu);

        final CheckBox Duel = findViewById(R.id.duel);
        final CheckBox MiniJeu = findViewById(R.id.minijeu);
        final CheckBox Tournee = findViewById(R.id.tournée);
        final CheckBox Dilem = findViewById(R.id.dilem);
        final CheckBox Role = findViewById(R.id.role);


        Duel.setChecked(HomePage.Duel);
        MiniJeu.setChecked(HomePage.MiniJeu);
        Tournee.setChecked(HomePage.Tournee);
        Dilem.setChecked(HomePage.Dilem);
        Role.setChecked(HomePage.Role);


        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seek.getProgress() == 0) {
                    EVENT_PROBA = 0;
                    text.setText("Aucun");
                }
                if (seek.getProgress() == 1) {
                    EVENT_PROBA = 15;
                    text.setText("Faible");
                }
                if (seek.getProgress() == 2) {
                    EVENT_PROBA = 25;
                    text.setText("Normal");
                }
                if (seek.getProgress() == 3) {
                    EVENT_PROBA = 35;
                    text.setText("Fréquent");
                }
                if (seek.getProgress() == 4) {
                    EVENT_PROBA = 45;
                    text.setText("Très Fréquent");
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });


        Duel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomePage.Duel = Duel.isChecked();
            }
        });

        MiniJeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomePage.MiniJeu = MiniJeu.isChecked();
            }
        });

        Tournee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomePage.Tournee = Tournee.isChecked();
            }
        });

        Dilem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomePage.Dilem = Dilem.isChecked();
            }
        });

        Role.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomePage.Role = Role.isChecked();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent myIntent = new Intent(ParameterPage.this, HomePage.class);
                startActivity(myIntent);
                finish();
            }

        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ParameterPage.this, HomePage.class);
                startActivity(myIntent);
                finish();
            }

        });

    }

}
