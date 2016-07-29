package com.augmentis.ayp.keep_walking;


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
    public Date dateKeepwalking;
    boolean flagAdd = false;
    public KeepWalking keepWalking;

    private static final String KEEPWALKING_ID = "ID";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_dialog_title, container, false);
        inputTitle = (EditText) v.findViewById(R.id.title_dialog);
        dateText = (TextView) v.findViewById(R.id.date_dialog);
        dateKeepwalking = new Date();

        UUID _id = (UUID) getArguments().getSerializable(KEEPWALKING_ID);

        if (_id == null)
        {
            flagAdd = true;
        }
        else
        {
            keepWalking = KeepWalkingLab.getInstance().getKeepWalkingById(_id);
            inputTitle.setText(keepWalking.getTitle());
        }

        return v;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("TITLE: ")
                .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (flagAdd == true)
                        {
                            KeepWalking keepwalking = new KeepWalking();
                            keepwalking.setTitle(inputTitle.getText().toString());
                            keepwalking.setKeepwalkingDate(dateKeepwalking);
                            KeepWalkingLab keepWalkingLab = KeepWalkingLab.getInstance();       //สร้าง object ใหม่ เพื่อใช้ ArrayList
                            keepWalkingLab.keepWalkingList.add(keepwalking);
                        }
                        else
                        {
                            keepWalking.setTitle(inputTitle.getText().toString());
                            keepWalking.setKeepwalkingDate(dateKeepwalking);
                        }

                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);

                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
    }
}
