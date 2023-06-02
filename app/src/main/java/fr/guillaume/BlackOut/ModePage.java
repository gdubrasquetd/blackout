package fr.guillaume.BlackOut;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.io.InputStream;

import static fr.guillaume.BlackOut.HomePage.buttonClick;

public class ModePage extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modepage);

        final ToggleButton soft = findViewById(R.id.softButton);
        final ToggleButton medium = findViewById(R.id.mediumButton);
        final ToggleButton hard = findViewById(R.id.hardButton);
        Button jouer = findViewById(R.id.jouer);


        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);

                HomePage.game.getVeritesTmp().clear();
                HomePage.game.getVeritesList().clear();

                HomePage.game.getActionsTmp().clear();
                HomePage.game.getActionsList().clear();

                if (soft.isChecked()) {
                    try {
                        InputStream actionStream = getAssets().open("actionSoft.json");
                        HomePage.game.fillJson(actionStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        InputStream veriteStream = getAssets().open("veriteSoft.json");
                        HomePage.game.fillJson(veriteStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (medium.isChecked()) {
                    try {
                        InputStream actionStream = getAssets().open("actionMedium.json");
                        HomePage.game.fillJson(actionStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        InputStream veriteStream = getAssets().open("veriteMedium.json");
                        HomePage.game.fillJson(veriteStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (hard.isChecked()) {
                    try {
                        InputStream actionStream = getAssets().open("actionHard.json");
                        HomePage.game.fillJson(actionStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        InputStream veriteStream = getAssets().open("veriteHard.json");
                        HomePage.game.fillJson(veriteStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (!soft.isChecked() && !medium.isChecked() && !hard.isChecked()) {
                    alertDialog();
                } else {

                    if (!PersonalizePage.actionPerso.isEmpty()) {
                        HomePage.game.getActionsList().addAll(PersonalizePage.actionPerso);
                    }

                    if (!PersonalizePage.veritePerso.isEmpty()) {
                        HomePage.game.getVeritesList().addAll(PersonalizePage.veritePerso);
                    }

                    Intent myIntent = new Intent(ModePage.this, ChoicePage.class);
                    startActivity(myIntent);
                    finish();
                }

            }
        });
    }

    private void alertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        dialog.setMessage("Vous devez selectionner au moins un mode de jeu");
        dialog.setTitle("Selection de mode");
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
