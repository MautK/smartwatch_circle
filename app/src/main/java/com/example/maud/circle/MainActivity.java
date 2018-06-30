package com.example.maud.circle;

import android.content.Context;
import android.graphics.Canvas;
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

    public SensorManager mSensorManager;
    public Sensor mGyroscope;
    public Sensor mGravitySensor;
    public Sensor mMagnetometer;
    public Sensor mRotation;
    public Sensor mMagneticRotationVector;
    public Sensor mAccelerometer;

    public float[] mGravity;
    public float[] mMagneticRotationData;
    private float azimutInDegrees;

    private MyView circleMyView;//= new MyView(this.getApplicationContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        circleMyView = new MyView(this);
//        setContentView(circleMyView);

        circleMyView = new MyView(this.getApplicationContext());
        setContentView(circleMyView);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mGravitySensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mRotation = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        mMagneticRotationVector = mSensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "onResume: onResume");
        mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mGravitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mRotation, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mMagneticRotationVector, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
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
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {
             mMagneticRotationData = event.values;
            Log.d("data", "onSensorChanged: magnetic field " + " " + mMagneticRotationData[0]);
        }

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            mGravity = event.values;
            Log.d("data", "onSensorChanged: accelerometer " + " " + mGravity[0]);
        }

        if (mGravity != null && mMagneticRotationVector != null) {
            sensorAction();
        }
    }

    public void sensorAction() {
        float R[] = new float[9];
        float I[] = new float[9];

        boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mMagneticRotationData);
        if (success) {
            float orientation[] = new float[3];
            SensorManager.getOrientation(R, orientation);
            float azimut = orientation[0];
            float pitch = orientation[1];
            float roll = orientation[2];

            azimutInDegrees = (float) Math.toDegrees(azimut);
            if (azimutInDegrees < 0.0f) {
                azimutInDegrees += 360.0f;
            }

//            MyView newMyView = new MyView(this);
//            circleMyView.draw(canvas);
//            circleMyView.setDegrees(azimutInDegrees);
//            circleMyView.drawCircle();

            circleMyView.setDegrees(azimutInDegrees);
            Log.d("data", "onSensorChanged: azimut" + azimutInDegrees);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("STOP", "onStop: STOP");
    }
}