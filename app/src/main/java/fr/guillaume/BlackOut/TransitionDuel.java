package fr.guillaume.BlackOut;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;

public class TransitionDuel extends Activity {
    AnimationDrawable anim;
    AnimationDrawable anim2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitionduel);

        ConstraintLayout fond = findViewById(R.id.fond);


        ImageView imageView = findViewById(R.id.image);
        imageView.setBackgroundResource(R.drawable.duelanim);
        anim = (AnimationDrawable) imageView.getBackground();

        ImageView imageView2 = findViewById(R.id.fondevent);
        imageView2.setBackgroundResource(R.drawable.eventanim);
        anim2 = (AnimationDrawable) imageView2.getBackground();

        final CountDownTimer count = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                Intent myIntent = new Intent(TransitionDuel.this, DuelPage.class);
                startActivity(myIntent);
                finish();
            }
        }.start();

        fond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.cancel();
                Intent myIntent = new Intent(TransitionDuel.this, DuelPage.class);
                startActivity(myIntent);
                finish();
            }
        });


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        anim.start();
        anim2.start();
    }
}

