package com.magiczooowls.ripinmobi;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.List;


public class PhotoDisplayActivity extends ListActivity {

    private static ParseQueryAdapter<Photos> mainAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_display);
        ParseQuery<ParseObject> query = ParseQuery.getQuery(ParseConstants.CLASS_PHOTO);
        try {
            List<ParseObject> mAnswer= query.find();
            for(ParseObject parseObject:mAnswer){
                Log.d("TAKADAI", parseObject.getObjectId() + " "+parseObject.getString("test"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        CustomAdapter mCustomAdapter = new CustomAdapter(this);
        mCustomAdapter.setObjectsPerPage(5);
//        listView = (ListView)findViewById(R.id.list);

        // Default view is all meals
        setListAdapter(mCustomAdapter);
    }


}
