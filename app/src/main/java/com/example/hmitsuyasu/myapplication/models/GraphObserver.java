package com.example.hmitsuyasu.myapplication.models;

import android.util.Log;
import org.jetbrains.annotations.NotNull;

public class GraphObserver implements Observer {

    private String TAG = getClass().getSimpleName();

    @Override
    public void update(@NotNull NumberGenerator generator) {
        Log.d(TAG, "GraphObserver:");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            Log.d(TAG, "*");
        }
        Log.d(TAG, "");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
    }
}
