package com.example.justingil1748.mobivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class Game1HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private NumberPicker np1, np2, dp;
    private Button startButton;

    //Initializing a new string array with elements(4 Directions)
    private final String[] values= {"North","East", "South", "West"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitygamehome1);

        np1 = (NumberPicker) findViewById(R.id.np1);
        np2 = (NumberPicker) findViewById(R.id.np2);
        dp = (NumberPicker) findViewById(R.id.dp);
        startButton = (Button) findViewById(R.id.button4);

        //Set the min/max value of NumberPicker
        np1.setMinValue(1);
        np1.setMaxValue(8);
        np2.setMinValue(1);
        np2.setMaxValue(8);

        np1.setWrapSelectorWheel(true);
        np2.setWrapSelectorWheel(true);

        dp.setMinValue(0); //from array first value
        //Specify the maximum value/number of NumberPicker
        dp.setMaxValue(values.length-1); //to array last value

        //Specify the NumberPicker data source as array elements
        dp.setDisplayedValues(values);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        dp.setWrapSelectorWheel(true);

        //when the start buttion is clicked
        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == startButton){
            //finish current activity and send coordinates and direction to GAME activity
            finish();
            Intent i = new Intent(this, Game1.class);
            i.putExtra("cor1", np1.getValue());
            i.putExtra("cor2", np2.getValue());
            i.putExtra("initDir", dp.getValue());
            startActivity(i);
        }
    }
}
