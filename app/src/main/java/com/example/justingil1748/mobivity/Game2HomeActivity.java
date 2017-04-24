package com.example.justingil1748.mobivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

/**
 * Created by justingil1748 on 4/23/17.
 */

public class Game2HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private NumberPicker np1, np2, dp, targetNp1, targetNp2, dp2, maxActionNp;
    private Button startButton;
    int minCoordinate = 1;
    int maxCoordinate = 8;
    int INTMAX = Integer.MAX_VALUE;

    //Initializing a new string array with elements(4 Directions)
    private final String[] values= {"North","East", "South", "West"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitygamehome2);

        //initialize numberpickers and button
        np1 = (NumberPicker) findViewById(R.id.np1);
        np2 = (NumberPicker) findViewById(R.id.np2);
        dp = (NumberPicker) findViewById(R.id.dp);
        targetNp1 = (NumberPicker) findViewById(R.id.targetNp1);
        targetNp2 = (NumberPicker) findViewById(R.id.targetNp2);
        dp2 = (NumberPicker) findViewById(R.id.dp2);
        startButton = (Button) findViewById(R.id.button4);
        maxActionNp = (NumberPicker) findViewById(R.id.maxActionNp);

        //Set the min/max value of NumberPicker
        np1.setMinValue(minCoordinate);
        np1.setMaxValue(maxCoordinate);
        np2.setMinValue(minCoordinate);
        np2.setMaxValue(maxCoordinate);

        targetNp1.setMinValue(minCoordinate);
        targetNp1.setMaxValue(maxCoordinate);
        targetNp2.setMinValue(minCoordinate);
        targetNp2.setMaxValue(maxCoordinate);
        maxActionNp.setMinValue(minCoordinate);
        maxActionNp.setMaxValue(INTMAX);

        np1.setWrapSelectorWheel(true);
        np2.setWrapSelectorWheel(true);
        targetNp1.setWrapSelectorWheel(true);
        targetNp2.setWrapSelectorWheel(true);
        maxActionNp.setWrapSelectorWheel(true);

        //from array first value
        dp.setMinValue(0);
        dp2.setMinValue(0);

        //Specify the maximum value/number of NumberPicker
        dp.setMaxValue(values.length - 1); //to array last value
        dp2.setMaxValue(values.length - 1);

        //Specify the NumberPicker data source as array elements
        dp.setDisplayedValues(values);
        dp2.setDisplayedValues(values);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        dp.setWrapSelectorWheel(true);
        dp2.setWrapSelectorWheel(true);

        //when the start buttion is clicked
        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == startButton){
            //finish current activity and send coordinates and direction to GAME activity
            finish();
            Intent i = new Intent(this, Game2.class);
            i.putExtra("cor1", np1.getValue());
            i.putExtra("cor2", np2.getValue());
            i.putExtra("initDir", dp.getValue());

            i.putExtra("tarCor1", targetNp1.getValue());
            i.putExtra("tarCor2", targetNp2.getValue());
            i.putExtra("tarInitDir", dp2.getValue());

            i.putExtra("action", maxActionNp.getValue());

            startActivity(i);
        }
    }
}