package com.sugary.jsonparsermaptest.utils;

import android.util.Log;

/**
 * Created by Ethan on 2017/6/21.
 */

public class LOG {

    private boolean isDebug = true;

    public static void D(String tag, String msg){
        Log.d(tag,msg);
    }
}
