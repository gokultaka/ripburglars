package com.magiczooowls.ripinmobi;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

/**
 * Created by Resh on 5/23/2015.
 */
public class RipBurglars extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        Parse.initialize(this, "I6BRmv3FgckULOOTK8hBqIOO1kUchoPfF34Gp88B", "7lO5UEBurNh0TLff8vwTOso7mKDskzSmsSRVVeJs");
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParseObject.registerSubclass(Photos.class);



    }
}
