package com.scm.subodhyadav.teachneedy;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by subodhyadav on 14/11/16.
 */

public class GlobalString extends AppCompatActivity{
    private String mGlobalVarValue;

    public String getGlobalVarValue() {
        return mGlobalVarValue;
    }

    public void setGlobalVarValue(String str) {
        mGlobalVarValue = str;
    }
}
