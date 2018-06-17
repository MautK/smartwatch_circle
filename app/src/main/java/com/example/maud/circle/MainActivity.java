package com.example.maud.circle;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends WearableActivity {

    private TextView mTextView;
    private MyView mMyView;
    public SensorManager mSensorManager;
    private Sensor mGyroscope;
    private Sensor mMagnetometer;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(new MyView(this));


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        //do we have this one the smartwatch?
        mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null){
            // Success! There's a gyroscope.
            // action
        }
        else {
            // Failure! No gyroscope.
        }

        //to get all the different sensor types
        final List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor type : deviceSensors) {
            Log.e("sensors", type.getStringType());
            //geomagnetic sensor used for users orientation (if accelerometer is not present)
            //returns x,y,z for each sensor event
            //rotational vector sensor is ideal for compasses


        }
    }
}