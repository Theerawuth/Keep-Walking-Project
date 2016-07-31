package com.augmentis.ayp.keep_walking;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.UUID;

public class EditKeepWalkingActivity extends FragmentActivity {
    private static final String KEEPWALKING_ID = "ID";
    private static final String TAG = "TestTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_keep_walking);

        Bundle bundle = new Bundle();

        UUID test = (UUID) getIntent().getSerializableExtra(KEEPWALKING_ID);
        bundle.putSerializable(KEEPWALKING_ID, test);

        Log.d(TAG,"UUID = " + test);
        FragmentManager fm = getSupportFragmentManager();
        Fragment f = new UpdateFragment();
        f.setArguments(bundle);
        fm.beginTransaction()
                .add(R.id.fragment_container2, f)
                .commit();
    }

}
