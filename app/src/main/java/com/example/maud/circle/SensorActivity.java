package com.example.maud.circle;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorActivity extends Activity implements SensorEventListener {

    public SensorManager mSensorManager;
    private Sensor mMagneticSensor;
    int compass;
    float [] rMat = new float[9];
    float [] orientation = new float[9];

    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mMagneticSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    //as little action as possible within this function
    @Override
    public void onSensorChanged(SensorEvent event) {
        //check first which sensor is getting data
        if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            //store data in matrix
            SensorManager.getRotationMatrixFromVector(rMat, event.values);
            // some math calculations from this video
            // https://www.youtube.com/watch?v=nOQxq2YpEjQ
            compass = (int) (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]+360)%360);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // more on the gyroscope, not sure if we can use this since it reports the rate of orientation but not according to where the north is
        // https://developer.android.com/guide/topics/sensors/sensors_motion
    }
}
