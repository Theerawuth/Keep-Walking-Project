package com.augmentis.ayp.keep_walking;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Theerawuth on 7/29/2016.
 */
public class EditDialogFragment extends DialogFragment {
    EditText inputTitle;
    TextView dateText;
    Date dateKeepWalking;


    //step1
    public static EditDialogFragment newInstance(){
        EditDialogFragment df = new EditDialogFragment();
        return df;
    }
//
    //step 3
//
//    @NonNull
//    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.activity_dialog_title, null); //สร้าง View เข้าไป
        inputTitle = (EditText) v.findViewById(R.id.title_input_dialog);
        dateText = (TextView) v.findViewById(R.id.date_dialog);
        dateKeepWalking = new Date(); // set date now

        AlertDialog.Builder builder =  new AlertDialog.Builder(getActivity());   // object ที่ใช้สร้าง Dialog แล้วกำหนดค่าต่างๆ ต่อ
        builder.setView(v);
        builder.setTitle("TITLE: ");
        builder.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                    KeepWalking keepwalking = new KeepWalking();
                    keepwalking.setTitle(inputTitle.getText().toString());
                    keepwalking.setKeepwalkingDate(dateKeepWalking);
                    KeepWalkingLab keepWalkingLab = KeepWalkingLab.getInstance();       //สร้าง object ใหม่ เพื่อใช้ ArrayList
                    keepWalkingLab.keepWalkingList.add(keepwalking);
                    Intent intent = new Intent(getActivity(),MainActivity.class);
                    startActivity(intent);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return  builder.create();
    }
}
