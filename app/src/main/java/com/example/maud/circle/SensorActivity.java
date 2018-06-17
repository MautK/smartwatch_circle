package com.example.maud.circle;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorActivity extends Activity implements SensorEventListener {

    public SensorManager mSensorManager;
    private Sensor mMagneticSensor;

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
        //check which value of the gyroscope we need
        // need x and y
        float xCompass = event.values[0];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // more on the gyroscope, not sure if we can use this since it reports the rate of orientation but not according to where the north is
        // https://developer.android.com/guide/topics/sensors/sensors_motion
    }
}
