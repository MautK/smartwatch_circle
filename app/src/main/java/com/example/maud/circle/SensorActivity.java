package com.example.maud.circle;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class SensorActivity extends Activity implements SensorEventListener {

    public SensorManager mSensorManager;
    private Sensor mGyroscope;
    private Sensor mMagnetometer;
    private Sensor mRotation;
    int compass;
    float [] rMat = new float[9];
    float [] orientation = new float[9];

    private double x = 0.0;
    private double y = 0.0;
    private double z = 0.0;

    String TAG = "empty";

    @Override
    protected void onResume(){
        super.onResume();
        int d = Log.d(TAG, "setData: yeah");
        mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mRotation, SensorManager.SENSOR_DELAY_NORMAL);



    }

    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    //as little action as possible within this function
    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "onSensorChanged: yeah");
        //check first which sensor is getting data
        if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            //store data in matrix
            SensorManager.getRotationMatrixFromVector(rMat, event.values);
            // some math calculations from this video
            // https://www.youtube.com/watch?v=nOQxq2YpEjQ
            compass = (int) (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]+360)%360);
            //display data
            setData(event.values[0], event.values[1], event.values[2]);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // more on the gyroscope, not sure if we can use this since it reports the rate of orientation but not according to where the north is
        // https://developer.android.com/guide/topics/sensors/sensors_motion
    }

    void setData(float newX, float newY, float newZ){
        x = newX;
        y = newY;
        z = newZ;
    }
}
