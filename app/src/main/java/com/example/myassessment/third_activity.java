package com.example.myassessment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class third_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button button_blue, button_red, button_reset;
        final RelativeLayout relativeLayout;

        //set button for blue with respective id
        button_blue = findViewById(R.id.background_button_blue);

        //set button for red with respective id
        button_red = findViewById(R.id.background_button_red);

        //set reset button with respective id
        button_reset = findViewById(R.id.background_button_reset);

        // set relative layout with its id
        relativeLayout = findViewById(R.id.rlVar1);

        //onClick function for background_blue
        button_blue.setOnClickListener(v -> {
            // set color
            relativeLayout.setBackgroundResource(R.color.blue);
        });

        //repeat for background_red
        button_red.setOnClickListener(v -> {
            // set color
            relativeLayout.setBackgroundResource(R.color.red);
        });

        //reset to white
        button_reset.setOnClickListener(v -> {
            // set color
            relativeLayout.setBackgroundResource(R.color.white);
        });
    } //end onCreate
} //end third_activity