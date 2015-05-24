package com.magiczooowls.ripinmobi;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by Resh on 5/23/2015.
 */
@ParseClassName(ParseConstants.CLASS_PHOTO)
public class Photos extends ParseObject{
    public Photos(){

    }

    public ParseFile getPhoto(){
        return getParseFile(ParseConstants.KEY_PHOTO_PHOTOUPLOADED);
    }

    public void setPhoto(ParseFile photo){
        put(ParseConstants.KEY_PHOTO_PHOTOUPLOADED,photo);
    }
}
