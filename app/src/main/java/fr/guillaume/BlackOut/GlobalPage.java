package fr.guillaume.BlackOut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static fr.guillaume.BlackOut.HomePage.buttonClick;

public class GlobalPage extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.globalpage);

        final TextView text = findViewById(R.id.text);
        final Button menu = findViewById(R.id.menu);

        char[] tab = {'A', 'E', 'O', 'I', 'M', 'L', 'N', 'S'};
        Random r = new Random();
        char c = tab[r.nextInt(tab.length)];
        String letter = "\"" + c + "\"";

        text.setText(String.format(HomePage.game.getGlobal(), letter));

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent myIntent = new Intent(GlobalPage.this, ChoicePage.class);
                startActivity(myIntent);
                finish();
            }

        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(GlobalPage.this, HomePage.class);
                startActivity(myIntent);
            }

        });
    }
}
