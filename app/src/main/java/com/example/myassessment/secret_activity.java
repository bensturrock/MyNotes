package com.example.myassessment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class secret_activity extends AppCompatActivity
{
    private SensorManager mSensorManager; //instantiate SensorManager class
    private float accelerometer, accelerometerCurrent, accelerometerLast; //instantiate private floats for sensor

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE); 	// Get sensor manager
        Objects.requireNonNull(mSensorManager).registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        accelerometer = 10f; //base reading which accelerometer calculations are compared with
        accelerometerCurrent = SensorManager.GRAVITY_EARTH; //makes accelerometerCurrent equal to earth gravity
        accelerometerLast = SensorManager.GRAVITY_EARTH; //makes accelerometerLast equal to earth gravity
    } //end onCreate

    private final SensorEventListener mSensorListener;
    {
        mSensorListener = new SensorEventListener()
        {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent)
            {
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];
                accelerometerLast = accelerometerCurrent;
                accelerometerCurrent = (float) Math.sqrt(x * x + y * y + z * z); //return the distance between this point and the other point.
                float delta = accelerometerCurrent - accelerometerLast; //calculate acceleration delta (difference between current and previous sensor recorded value)
                accelerometer = (accelerometer * 0.9f) + delta; //perform low-cut filter
                if (accelerometer > 12)
                {
                    Log.d(TAG,"Device has been shaken"); //logs that device has been shaken
                    Toast.makeText(getApplicationContext(), "You just shook this device!", Toast.LENGTH_LONG).show(); //display that a device shake has been detected
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy)
            {
            }
        };
    }

    @Override
    protected void onResume()
    {
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), //resume SensorListener when activity is active again
                SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    } //end onResume
    @Override
    protected void onPause()
    {
        mSensorManager.unregisterListener(mSensorListener); //de-register SensorListener when activity is not active to save battery/threads
        super.onPause();
    } //end onPause
} //end secret_activity