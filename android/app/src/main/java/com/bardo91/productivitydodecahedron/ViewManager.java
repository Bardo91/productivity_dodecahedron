package com.bardo91.productivitydodecahedron;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;


public class ViewManager {

    private ArrayList<TextView> textViews = new ArrayList<>();
    private ArrayList<TextView> labelViews = new ArrayList<>();
    private ArrayList<ImageView> imageViews = new ArrayList<>();
    private Activity mainActivity_ = null;

    public ViewManager(Activity _activity){
        mainActivity_ = _activity;
        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_1));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_1));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_1));

        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_2));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_2));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_2));

        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_3));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_3));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_3));

        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_4));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_4));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_4));

        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_5));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_5));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_5));

        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_6));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_6));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_6));

        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_7));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_7));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_7));

        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_8));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_8));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_8));

        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_9));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_9));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_9));

        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_10));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_10));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_10));

        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_11));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_11));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_11));

        textViews.add((TextView) mainActivity_.findViewById(R.id.tv_12));
        imageViews.add((ImageView) mainActivity_.findViewById(R.id.iv_12));
        labelViews.add((TextView) mainActivity_.findViewById(R.id.cat_12));

        for(ImageView view: imageViews){
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    createEditImageDialog(v);
                    return false;
                }
            });
        }

        for(TextView view: labelViews){
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    createEditLabelDialog(v);
                    return false;
                }
            });
        }

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


    private void createEditLabelDialog(final View _v){
        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity_);
        builder.setMessage(R.string.dialog_edit_label);

        LayoutInflater inflater = mainActivity_.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_edit_text, null);
        builder.setView(dialogView);

        final EditText ed = (EditText) dialogView.findViewById(R.id.label_edit);
        ed.setText(((TextView) _v).getText());

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                ((TextView) _v).setText(ed.getText());
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {} } );

        // Create the AlertDialog
        Dialog dialog = builder.create();
        dialog.show();
    }


    private void createEditImageDialog(final View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity_);
        builder.setMessage(R.string.dialog_edit_image);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

        // Create the AlertDialog
        Dialog dialog = builder.create();
        dialog.show();
    }
}
