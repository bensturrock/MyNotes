package com.example.myassessment.controller;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileHelper {
    static int TYPE_INTERNAL = 0;
    static int TYPE_EXTERNAL = 1;
    static String DEBUG_TAG = "LAB6_DEBUG";

    private static FileHelper instance = null;

    Context parentContext;

    public static FileHelper getInstance(Context context){
        if(instance == null){
            instance = new FileHelper();
        }
        instance.parentContext = context;
        return instance;
    }

    public void saveToInternalStorage(String filename, String data){
        try {
            // Open file output with the file name and the operating mode.
            FileOutputStream fos = parentContext.openFileOutput(filename, Context.MODE_PRIVATE);
            // Write data to file.
            fos.write(data.getBytes());
            // Close output stream.
            fos.close();
            Log.d("DEBUG", "file saved!");
        } catch (IOException e) {
            // Handle error messages here!
            e.printStackTrace();
            Toast.makeText(parentContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public String loadFromInternalStorage(String filename) {
        String result = "";
        FileInputStream fis = null;
        try {
            // Open file input stream with file name.
            fis = parentContext.openFileInput(filename);
            // Initialise the reader.
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            // Read file line-by-line.
            StringBuilder builder = new StringBuilder();
            String line = null;
            line = reader.readLine();
            while (line != null) {
                builder.append(line).append("\n"); // append line data + new line symbol
                line = reader.readLine();
            }
            // this will put all lines in a single string with a line break after each row
            result = builder.toString();
            // Close the stream and the reader.
            reader.close();
            fis.close();
            Log.d(DEBUG_TAG, "file loaded!");
            return result;
        } catch (FileNotFoundException e){
            e.printStackTrace();
            Toast.makeText(parentContext, "File not found!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            // Handle other error messages here!
            e.printStackTrace();
            Toast.makeText(parentContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        // make sure to handle it properly!
        return null;
    }

}
