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
import java.util.List;

public class MainActivity extends WearableActivity implements SensorEventListener {

    private TextView mTextView;
    private MyView mMyView;

    public SensorManager mSensorManager;
    public Sensor mGyroscope;
    public Sensor mMagnetometer;
    public Sensor mRotation;
    public Sensor mMagneticRotationVector;
//    private SensorActivity mSensorActivity;
//    private EventListener mEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(new MyView(this));

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mRotation = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        mMagneticRotationVector = mSensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);

        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensors) {
            Log.d("Sensors", "" + sensor.getName());
        }

//        mSensorActivity = new SensorActivity();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "onResume: onResume");
        //mMagnetometer doesn't give any data
        mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_NORMAL);
        //mGyroscope and mRotation both give data
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mRotation, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mMagneticRotationVector, SensorManager.SENSOR_DELAY_NORMAL);

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
        //check first which sensor is getting data
        if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {

            float mRotationData = event.values[0];
//            Log.d("mRotationData", "onSensorChanged: SensorData" + Float.toString(mRotationData));
        }

        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {

            float mGyroscopeData = event.values[0];
//            Log.d("mGyroscopeData", "onSensorChanged: SensorData" + Float.toString(mGyroscopeData));
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {
            float mMagneticRotationData = event.values[0];
            Log.d("mMagneticRotationData", "onSensorChanged: SensorData" + Float.toString(mMagneticRotationData));
//
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("STOP", "onStop: STOP");
    }
}