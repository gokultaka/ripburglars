package com.magiczooowls.ripinmobi;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Resh on 5/23/2015.
 */
public class PhotoAdapter extends ArrayAdapter<String> {
    public PhotoAdapter(Context context, List<String> url) {
        super(context,R.layout.photo_display, url);
    }
}
