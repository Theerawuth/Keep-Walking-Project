package com.augmentis.ayp.keep_walking;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Theerawuth on 7/28/2016.
 */
public class KeepWalkingHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView titleEditText;
    private TextView dateTextView;
    KeepWalking _keepWalking;
    private FragmentActivity _activity;
    private static final String TAG = "TestTAG";


    public KeepWalkingHolder(View itemView, FragmentActivity activity){
        super(itemView);
        Log.d(TAG,"KeepWalkingHolder2");
        _activity = activity;
        titleEditText = (TextView) itemView.findViewById(R.id.holder_title_edit_text);
        dateTextView = (TextView) itemView.findViewById(R.id.holder_date_text_view);
        itemView.setOnClickListener(this);

    }

    public void bindKeepWalking(KeepWalking keepwalking, int position){
        Log.d(TAG,"bindKeepWalking2");
        _keepWalking = keepwalking;
        titleEditText.setText(_keepWalking.getTitle());
        dateTextView.setText(_keepWalking.getKeepWalkingDate());

    }

    @Override
    public void onClick(View v) {
        Log.d(TAG,"TestOnClick");

    }
}
