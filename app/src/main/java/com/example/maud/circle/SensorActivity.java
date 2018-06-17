package com.example.maud.circle;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorActivity extends Activity implements SensorEventListener {

    public SensorManager mSensorManager;

    @Override
    protected void onResume(){
        super.onResume();
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
        float xCompass = event.values[0];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
