package com.example.maud.circle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.EventListener;
import java.util.List;

public class MainActivity extends WearableActivity {

    private TextView mTextView;
    private MyView mMyView;
    public SensorManager mSensorManager;
    private Sensor mGyroscope;
    private Sensor mMagnetometer;
    private Sensor mRotation;

    private EventListener mEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(new MyView(this));

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mRotation = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

        SensorActivity mSensorActivity = new SensorActivity();
        mSensorActivity.logSomething();
    }

}