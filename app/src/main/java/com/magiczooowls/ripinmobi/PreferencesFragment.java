package com.magiczooowls.ripinmobi;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gc.materialdesign.views.Button;
import com.gc.materialdesign.views.CheckBox;
import com.gc.materialdesign.views.Switch;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;


/**
 * A simple {@link Fragment} subclass.
 */
public class PreferencesFragment extends android.support.v4.app.Fragment {

    private Switch mCheckBox;
    private EditText mTwitterId;
    private EditText mTimeInterval;
    private Button mButton;
    private ProgressBar mProgressBar;
    private Button mForceStart;
    public PreferencesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preferences, container, false);


    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.INVISIBLE);
        mCheckBox = (Switch)view.findViewById(R.id.checkbox);
        mTwitterId = (EditText)view.findViewById(R.id.twitterId);
        mTimeInterval = (EditText)view.findViewById(R.id.timeInterval);
        mButton = (Button)view.findViewById(R.id.button);
        mForceStart = (Button)view.findViewById(R.id.button);
        ParseQuery mParseQuery = ParseQuery.getQuery(ParseConstants.CLASS_PREF);
        try {
           ParseObject mParseObject = mParseQuery.get(ParseConstants.KEY_ID);
            String enabled = mParseObject.getString(ParseConstants.KEY_PREF_ENABLED);
            if(enabled.equals("y")){
                mCheckBox.setChecked(true);
            }else{
                mCheckBox.setChecked(false);
            }
            String twit = mParseObject.getString(ParseConstants.KEY_PREF_TWITTERID);
            mTwitterId.setText(twit);
            String time = mParseObject.getString(ParseConstants.KEY_PREF_TIMEDIFF);
            mTimeInterval.setText(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                //update
                ParseQuery mParseQuery = ParseQuery.getQuery(ParseConstants.CLASS_PREF);
                try {
                    ParseObject mParseObject=mParseQuery.get(ParseConstants.KEY_ID);
                    String enabled = "n";
                    if(mCheckBox.isCheck()){
                        enabled="y";

                    }
                    mParseObject.put(ParseConstants.KEY_PREF_ENABLED,enabled);
                    mParseObject.put(ParseConstants.KEY_PREF_TIMEDIFF,mTimeInterval.getText().toString());
                    mParseObject.put(ParseConstants.KEY_PREF_TWITTERID,mTwitterId.getText().toString());
                    mParseObject.save();
                    mProgressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(view.getContext(),"Saved successfully",Toast.LENGTH_LONG).show();
                } catch (ParseException e) {
                    Toast.makeText(view.getContext(),"This is embarassing",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }
}
