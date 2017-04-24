package com.example.justingil1748.mobivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by justingil1748 on 4/23/17.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button game1, game2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        game1 = (Button) findViewById(R.id.button);
        game2 = (Button) findViewById(R.id.button2);

        game1.setOnClickListener(this);
        game2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
        Intent i;
        if(v == game1){
            i = new Intent(this, Game1HomeActivity.class);
            startActivity(i);
        }
        else
            i = new Intent(this, Game2HomeActivity.class);

        startActivity(i);
    }
}
