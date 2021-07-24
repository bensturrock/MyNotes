package com.example.myassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    Button send_button, settings_button, open_toast, clear_button, clear_button_desc, about_button, load_button; //define variables for Buttons
    EditText send_title, send_desc; //define variables for EditTexts

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send_button = findViewById(R.id.send_button_id);
        send_title = findViewById(R.id.send_text_id);
        send_desc = findViewById(R.id.send_description_id);
        settings_button = findViewById(R.id.main_settings);
        open_toast = findViewById(R.id.main_open_toast);
        clear_button = findViewById(R.id.main_clear_text_button);
        clear_button_desc = findViewById(R.id.main_clear_desc_button);
        about_button = findViewById(R.id.main_about);
        load_button = findViewById(R.id.main_load);

        Toast.makeText(this, "The onCreate lifecycle callback has just ran", Toast.LENGTH_SHORT).show();

        // add onClickListener in 'send' button
        send_button.setOnClickListener(v ->
        {
            if (TextUtils.isEmpty(send_title.getText().toString())) //checks if EditText is empty
            {
                Toast.makeText(MainActivity.this, "Empty field not allowed!" + "\n" +  "Please Enter Text", Toast.LENGTH_LONG).show(); //display Toast as specified
            }
            else //runs when EditText is NOT empty
            {
                //get value inputted by the user from NoteTitle EditText
                //convert it into a String
                String ttl = send_title.getText().toString();

                //get value inputted by the user from NoteTitle EditText
                //convert it into a String
                String des = send_desc.getText().toString();

                //Create Intent object of this class Context() to new Activity class
                Intent intent = new Intent(getApplicationContext(), second_activity.class);

                intent.putExtra("title_key", ttl); //key value pair for note title
                intent.putExtra("description_key", des); //key value pair for note description

                //start the Intent
                startActivity(intent);
            }
        });

        // add onClickListener in 'open toast' button
        open_toast.setOnClickListener(v ->
        {
            //Create Intent object of this class Context() to new Activity class
            Intent intent = new Intent(getApplicationContext(), toast_activity.class);

            //start the Intent
            startActivity(intent);
        });

        // add onClickListener in 'clear' button
        load_button.setOnClickListener(v ->
        {
            //Create Intent object of this class Context() to new Activity class
            Intent intent = new Intent(getApplicationContext(), second_activity.class);

            //start the Intent
            startActivity(intent);
        });

        // add onClickListener in 'clear' button
        clear_button.setOnClickListener(v ->
        {
            send_title.getText().clear(); //clear text in EditText Title
        });

        // add onClickListener in 'clear' button
        clear_button_desc.setOnClickListener(v ->
        {
            send_desc.getText().clear(); //clear text in EditText Description
        });

        //open settings on button click
        settings_button.setOnClickListener(v ->
        {

            //Create Intent object of this class Context() to new Activity class
            Intent intent = new Intent(getApplicationContext(), third_activity.class);
            Toast.makeText(MainActivity.this, "You opened the Settings!", Toast.LENGTH_LONG).show();

            //start the Intent
            startActivity(intent);
        });

        settings_button.setOnLongClickListener(v ->
        {
            //Create Intent object of this class Context() to new Activity class
            Intent intent = new Intent(getApplicationContext(), secret_activity.class);

            //start the Intent
            startActivity(intent);

            return false;
        });

        //open settings on button click
        about_button.setOnClickListener(v -> Toast.makeText(MainActivity.this, "By Ben Sturrock, 2021", Toast.LENGTH_LONG).show());
    } //end onCreate
} //end MainActivity

