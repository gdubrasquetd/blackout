package fr.guillaume.BlackOut;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

public class StartingPage extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startingpage);
        prevent();
    }

    private void prevent() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        dialog.setMessage("L'abus d'alcool est dangeureux pour la santé. " +
                "En poursuivant vous confirmez être en âge du consommer de l'alcool et vous assumez être seuls responsables des éventuelles conséquences que pourrait engendrer l'utilisation de BlackOut. \n" +
                "Les quantités d'alcool sont seulement indicatives et ne sont en aucun cas obligatoires. \n" +
                "Vous vous engagez à ne pousser ou ne forcer personne à consommer de l'alcool.");
        dialog.setTitle("Attention");
        dialog.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Intent myIntent = new Intent(StartingPage.this, HomePage.class);
                        startActivity(myIntent);
                        finish();
                    }
                });
        dialog.setNegativeButton("Quitter",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        finish();
                        System.exit(0);
                    }
                });
        dialog.setCancelable(false);
        AlertDialog alert = dialog.create();
        alert.show();
    }
}
