package fr.guillaume.BlackOut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static fr.guillaume.BlackOut.HomePage.buttonClick;

public class DuelPage extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duelpage);

        final TextView text = findViewById(R.id.text);
        final Button menu = findViewById(R.id.menu);
        Player random = HomePage.game.getRandomName(null);
        Player random2 = HomePage.game.getRandomName(random);

        text.setText(String.format(HomePage.game.getDuel(), random.getName().toString(), random2.getName().toString()));

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent myIntent = new Intent(DuelPage.this, ChoicePage.class);
                startActivity(myIntent);
                finish();
            }

        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DuelPage.this, HomePage.class);
                startActivity(myIntent);
                finish();
            }

        });
    }
}
