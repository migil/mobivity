package com.example.justingil1748.mobivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by justingil1748 on 4/23/17.
 */


public class Game1 extends AppCompatActivity implements View.OnClickListener{
    //member variables, coordinates and direction
    private int currCor1 = 0;
    private int currCor2 = 0;
    private int currDir = 0;

    private Button b_left, b_right, b_move;
    private TextView t_pos, t_dir;

    private final String[] values= {"North","East", "South", "West"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1);

        //initialize buttons and textViews
        b_left = (Button) findViewById(R.id.left_b);
        b_right = (Button) findViewById(R.id.right_b);
        b_move = (Button) findViewById(R.id.move_b);
        t_pos = (TextView) findViewById(R.id.pos_t);
        t_dir = (TextView) findViewById(R.id.dir_t);

        //receive initial data from MainActivity
        Intent i = getIntent();
        currCor1 = i.getIntExtra("cor1", 1);
        currCor2 = i.getIntExtra("cor2", 1);
        currDir = i.getIntExtra("initDir", 0);

        //Display current data
        displayValues();

        //set listeners for each buttons
        b_left.setOnClickListener(this);
        b_move.setOnClickListener(this);
        b_right.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //changing directions
        if(v == b_left || v == b_right){
            ++currDir;
            displayValues();
        }
        //move
        else{
            //check if the move is valid
            boolean validMove = false;

            switch (currDir % 4){
                case 0:  //north
                    if(currCor2 < 8) {
                        ++currCor2;
                        validMove = true;
                    }
                    break;
                case 1: //east
                    if(currCor1 < 8) {
                        ++currCor1;
                        validMove = true;
                    }
                        break;
                case 2: //south
                    if(currCor2 > 1) {
                        --currCor2;
                        validMove = true;
                    }
                    break;
                case 3: //west
                    if(currCor1 > 1) {
                        --currCor1;
                        validMove = true;
                    }
                    break;
            }

            //error message for invalid movement
            if(!validMove)
                Toast.makeText(getBaseContext(), "Can't move forward! Please change the direction." , Toast.LENGTH_SHORT ).show();
            else    //otherwise, display updated data
                displayValues();
        }
    }

    //display data
    void displayValues() {
        t_pos.setText("[" + currCor1 + "\t" + currCor2 + "]");
        t_dir.setText(values[currDir % 4]);
    }

}

