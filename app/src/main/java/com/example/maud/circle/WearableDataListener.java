package com.example.maud.circle;

import android.app.Service;
import android.util.Log;

import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

public class WearableDataListener extends WearableListenerService {

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        Log.d("data", "onDataChanged: " + dataEvents);
    }

    @Override
    public void onMessageReceived (MessageEvent messageEvent) {
        Log.d("message", "onMessageReceived: " + messageEvent);
    }



}
