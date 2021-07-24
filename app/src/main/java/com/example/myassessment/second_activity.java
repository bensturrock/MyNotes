package com.example.myassessment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myassessment.controller.Notify;

public class second_activity extends AppCompatActivity
{
    SharedPreferences sharedpreferences; //instantiate SharedPreferences
    public static final String CHANNEL_ID = "#123", CHANNEL_NAME = "my notification", CHANNEL_DESCRIPTION = "Test"; //creates required variables for NotificationChannel
    public TextView title_txt, description_txt; //define variables for TextViews
    Button return_main_button, save_button, load_button, clear_button, clear_button_desc; //define variables for Buttons
    public static final String mysharedpreference = "mypref", Name = "nameKey", Description = "descKey"; //keys for storing in SharedPrefs

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        title_txt = findViewById(R.id.received_value_id); //link TextView on layout with class variable
        description_txt = findViewById(R.id.received_value_desc);//link TextView on layout with class variable
        sharedpreferences = getSharedPreferences(mysharedpreference, //instantiate instance of SharedPreferences
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name))
        {
            title_txt.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Description))
        {
            description_txt.setText(sharedpreferences.getString(Description, ""));
        }

        NotificationChannel channel = new NotificationChannel( //builds new Notification Channel using below values
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH //IMPORTANCE_HIGH makes sound and shows onscreen, IMPORTANCE_DEFAULT only makes sound
        );
        channel.setDescription(CHANNEL_DESCRIPTION);
        NotificationManager manager = getSystemService(NotificationManager.class); //register Notification channel with the system
        manager.createNotificationChannel(channel); //creates the specified channel

        //link return button
        return_main_button = findViewById(R.id.activity_second_back);

        //link save button
        save_button = findViewById(R.id.activity_second_save);

        //link load button
        load_button = findViewById(R.id.activity_second_load);

        //link clear button
        clear_button = findViewById(R.id.activity_second_clear_title);

        //link clear button
        clear_button_desc = findViewById(R.id.activity_second_clear_desc);

        //link textView
        title_txt = findViewById(R.id.received_value_id);

        //link textView
        description_txt = findViewById(R.id.received_value_desc);

        // create getIntent object
        Intent intent = getIntent();

        //receive the sent key value pair via getStringExtra() method
        String ttl = intent.getStringExtra("title_key");

        //repeat for description
        String des = intent.getStringExtra("description_key");

        //display String into textView
        title_txt.setText(ttl);

        //display String into textView
        description_txt.setText(des);

        //open settings on button click
        return_main_button.setOnClickListener(v ->
        {
            finish(); //return to main activity + triggers OnDestroy lifecycle callback //
        });

        // add onClickListener in 'clear title' button
        clear_button.setOnClickListener(v ->
        {
            title_txt.setText(""); //clear text in TextView Title
        });

        // add onClickListener in 'clear title' button
        clear_button_desc.setOnClickListener(v ->
        {
            description_txt.setText(" "); //clear text in TextView Description
        });
    } //end onCreate

    public void saveNote(View view)
    {
        String n = title_txt.getText().toString();
        String d = description_txt.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Description, d);

        Notify.showNotification(this); //calls showNotification function, using user entered values as content

        Toast.makeText(second_activity.this, "Saving...", Toast.LENGTH_LONG).show();

        //changed from `commit` to `apply()`; former writes its data to persistent storage immediately, whereas `apply` will handle it in the background
        editor.apply();
    }

    public void loadNote(View view)
    {
        title_txt = findViewById(R.id.received_value_id);
        description_txt = findViewById(R.id.received_value_desc);
        sharedpreferences = getSharedPreferences(mysharedpreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) //checks if SharedPreferences object contains a Key Value Pair named 'Name'
        {
            title_txt.setText(sharedpreferences.getString(Name, "")); //sets TextView with the String stored from 'Name' Key Value Pair
        }
        if (sharedpreferences.contains(Description)) //checks if SharedPreferences object contains a Key Value Pair named 'Description'
        {
            description_txt.setText(sharedpreferences.getString(Description, "")); //sets TextView with the String stored from 'Description' Key Value Pair
        }
    }

} //end second_activity