package com.example.maud.circle;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.EventListener;

public class MainActivity extends WearableActivity implements SensorEventListener {

    private TextView mTextView;
    private MyView mMyView;

    public SensorManager mSensorManager;
    public Sensor mGyroscope;
    public Sensor mMagnetometer;
    public Sensor mRotation;
//    private SensorActivity mSensorActivity;
//    private EventListener mEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(new MyView(this));

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mRotation = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

//        mSensorActivity = new SensorActivity();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "onResume: onResume");
        mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mRotation, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    protected void onPause(){
        super.onPause();
        Log.d("onPause", "onPause: onPause");
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    //as little action as possible within this function
    public void onSensorChanged(SensorEvent event) {
        Log.d("sensorChanged", "onSensorChanged: yeah");
        //check first which sensor is getting data
        if(event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR){

            float mSomething = event.values[0];
            Log.d("bla", "onSensorChanged: SensorData" + Float.toString(mSomething));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("STOP", "onStop: STOP");
    }
}