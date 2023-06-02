package fr.guillaume.BlackOut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static fr.guillaume.BlackOut.HomePage.buttonClick;

public class RolePage extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rolepage);


        final TextView text = findViewById(R.id.text);
        final Button menu = findViewById(R.id.menu);
        ChoicePage.random = HomePage.game.getRandomName();
        ChoicePage.boy = HomePage.game.getBoy();
        ChoicePage.girl = HomePage.game.getGirl();
        ChoicePage.opposite = HomePage.game.getLastPlayer().isGenre() ? ChoicePage.girl : ChoicePage.boy;
        ChoicePage.same = HomePage.game.getLastPlayer().isGenre() ? ChoicePage.boy : ChoicePage.girl;

        text.setText(String.format(HomePage.game.getRole(), ChoicePage.random, ChoicePage.opposite, ChoicePage.same, ChoicePage.boy, ChoicePage.girl));

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent myIntent = new Intent(RolePage.this, ChoicePage.class);
                startActivity(myIntent);
                finish();
            }

        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RolePage.this, HomePage.class);
                startActivity(myIntent);
                finish();
            }

        });

    }
}