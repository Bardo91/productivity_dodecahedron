package com.bardo91.productivitydodecahedron;

import android.app.Activity;
import android.widget.TextView;

import java.util.ArrayList;


public class ViewManager {

    private ArrayList<TextView> textViews = new ArrayList<>();
    private Activity mainActivity_ = null;

    public ViewManager(Activity _activity){
        mainActivity_ = _activity;
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_1));
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_2));
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_3));
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_4));
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_5));
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_6));
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_7));
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_8));
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_9));
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_10));
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_11));
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_12));

    }


    public void updateTime(final int _id, final String _text){
        if(mainActivity_ == null)
            return;

        mainActivity_.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textViews.get(_id).setText(_text);
            }
        });
    }
}
