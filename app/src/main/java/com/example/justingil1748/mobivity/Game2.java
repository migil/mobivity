package com.example.justingil1748.mobivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

/**
 * Created by justingil1748 on 4/23/17.
 */

public class Game2 extends AppCompatActivity implements View.OnClickListener {
    //member variables, coordinates and direction
    private int currCor1 = 0;
    private int currCor2 = 0;
    private int currDir = 0;

    private Button b_left, b_right, b_move;
    private TextView t_pos, t_dir;
    private final String[] values = {"North", "East", "South", "West"};

    private int maxActions, targetpos1, targetpos2, tarInitDir;

    //store actions, 0-M, 1-L, 2-M
    Stack<Integer> actionStack = new Stack<Integer>();

    @Override
    public void onClick(View v) {

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
        maxActions = i.getIntExtra("action", 0);

        targetpos1 = i.getIntExtra("tarCor1", 1);
        targetpos2 = i.getIntExtra("tarCor2", 1);
        tarInitDir = i.getIntExtra("tarInitDir", 0);
        listPossibleList();
    }

    private void listPossibleList() {
        int horizontalMove = targetpos1 - currCor1;
        int verticalMove = targetpos2 - currCor2;

        boolean moveRight = (horizontalMove > 0);   //have to change direction to east
        boolean moveUp = (verticalMove > 0);        //have to change direction to north

        /*
            I couldn't finish implementation step, but I have an idea.
            1) calculate the minimum movement(distance from current to target)
            2) Using the minimum movement, implement a tree structure that has three branches(M,L,F)
            3) Set height of the tree to the max number of actions.
            4) Print all the possible action sequences, using DFS tree traversal

            Challenging part: I know how to find the shortest path, but if max possible action is greater than
                                the shortest path, there are a lot more possible cases.
        */
    }
}
