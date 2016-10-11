package io.github.smartmileage.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;


public class SMApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        // Normal app init code...
        init();
    }

    public void init() {
        LeakCanary.install(this);
    }
}
