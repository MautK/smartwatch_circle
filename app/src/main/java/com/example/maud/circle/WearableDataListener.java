package com.example.maud.circle;

import android.app.Service;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

public class WearableDataListener extends WearableListenerService {

    private static final String WEARABLE_DATA_PATH = "/wearable?data";

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        Log.d("data", "onDataChanged: " + dataEvents);
    }

    //here we are going to broadcast the messages locally so we can access them in the MainActivity
    @Override
    public void onMessageReceived (MessageEvent messageEvent) {
        Log.d("message", "onMessageReceived: " + messageEvent);
    }



}
