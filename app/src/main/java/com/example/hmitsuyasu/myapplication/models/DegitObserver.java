package com.example.hmitsuyasu.myapplication.models;

import android.util.Log;

public class DegitObserver implements Observer {
    private String TAG = getClass().getSimpleName();

    public void update(NumberGenerator generator) {
        Log.d(TAG, "DegitObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
    }
}
