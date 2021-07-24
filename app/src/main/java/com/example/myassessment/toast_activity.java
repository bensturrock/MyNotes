package com.example.myassessment;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

public class toast_activity extends AppCompatActivity
{
    Button button_one, button_two, button_three, button_four, button_five, button_six, button_seven, button_eight, button_nine; //define variables for Buttons

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        button_one = findViewById(R.id.toast_button_one);
        button_two = findViewById(R.id.toast_button_two);
        button_three = findViewById(R.id.toast_button_three);
        button_four = findViewById(R.id.toast_button_four);
        button_five = findViewById(R.id.toast_button_five);
        button_six = findViewById(R.id.toast_button_six);
        button_seven = findViewById(R.id.toast_button_seven);
        button_eight = findViewById(R.id.toast_button_eight);
        button_nine = findViewById(R.id.toast_button_nine);

        //display button 1 toast
        button_one.setOnClickListener(v -> makeText(toast_activity.this, "1", LENGTH_LONG).show());
        //display button 2 toast
        button_two.setOnClickListener(v -> makeText(toast_activity.this, "2", LENGTH_LONG).show());
        //display button 3 toast
        button_three.setOnClickListener(v -> makeText(toast_activity.this, "3", LENGTH_LONG).show());
        //display button 4 toast
        button_four.setOnClickListener(v -> makeText(toast_activity.this, "4", LENGTH_LONG).show());
        //display button 5 toast
        button_five.setOnClickListener(v -> makeText(toast_activity.this, "5", LENGTH_LONG).show());
        //display button 6 toast
        button_six.setOnClickListener(v -> makeText(toast_activity.this, "6", LENGTH_LONG).show());
        //display button 7 toast
        button_seven.setOnClickListener(v -> makeText(toast_activity.this, "7", LENGTH_LONG).show());
        //display button 8 toast
        button_eight.setOnClickListener(v -> makeText(toast_activity.this, "8", LENGTH_LONG).show());
        //display button 9 toast
        button_nine.setOnClickListener(v -> makeText(toast_activity.this, "9", LENGTH_LONG).show());
    } //end onCreate
} //end toast_activity