package com.example.maud.circle;

//import android.app.Activity;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class SensorActivity extends Activity implements SensorEventListener {
    private final SensorManager mSensorManagerActivty;
    private final Sensor mMagnetometer;

    public SensorActivity(){
       mSensorManagerActivty = (SensorManager)getSystemService(SENSOR_SERVICE);
       mMagnetometer = mSensorManagerActivty.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    String TAG = "empty";

//    protected void sensorOnResume() {
//        Log.d(TAG, "setData: yeah");
//        // these two lines are also specified in MainActivity
////        mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_NORMAL);
////        mSensorManager.registerListener(this, mRotation, SensorManager.SENSOR_DELAY_NORMAL);
//
//    }

//
//    protected void sensorPaused() {
////        mSensorManager.unregisterListener(this);
//        Log.d(TAG, "onPause: PAUSE");
//    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: onResume");
        mSensorManagerActivty.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: onPause");
        mSensorManagerActivty.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    //as little action as possible within this function
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "onSensorChanged: yeah");
        //check first which sensor is getting data
        if(event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR){

            float mSomething = event.values[0];
            Log.d(TAG, "onSensorChanged: SensorData" + Float.toString(mSomething));
        }
    }


}
