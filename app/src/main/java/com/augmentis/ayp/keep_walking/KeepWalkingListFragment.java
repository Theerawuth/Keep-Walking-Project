package com.augmentis.ayp.keep_walking;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class KeepWalkingListFragment extends Fragment {

    private static final String TAG = "TestTAG";
    private static final String DIALOG_ADD = "DIALOG_ADD";
    private Button addButton;
    private RecyclerView _recycleView;
    private KeepWalkingAdapter adapter;
    protected static final int REQUEST_UPDATE_WALKER = 200;
    private EditText input_title;
    private TextView date;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_keep_walking_list_fragment, container, false);

        _recycleView = (RecyclerView) v.findViewById(R.id.keep_recycle_view);
        _recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Log.d(TAG,"Test");
        updateUI();
        addButton = (Button) v.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                EditDialogFragment editDialogFragment = EditDialogFragment.newInstance();
                editDialogFragment.show(fm, DIALOG_ADD);
            }
        });
        return  v;

    }

    private void updateUI() {
        KeepWalkingLab keepwalkinglab = KeepWalkingLab.getInstance(getActivity());
        Log.d(TAG,"Test");
        if(!keepwalkinglab.getKeepWalkingList().isEmpty()) {
            Log.d(TAG,"Test2");
            List<KeepWalking> keepWalkingList = keepwalkinglab.getKeepWalkingList();
            if(adapter==null){
                adapter = new KeepWalkingAdapter(keepWalkingList, getActivity());
                _recycleView.setAdapter(adapter);
            }
            else
            {
                _recycleView.setAdapter(adapter);
            }


        }
    }

//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        // Get the layout inflater
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//
//        // Inflate and set the layout for the dialog
//        // Pass null as the parent view because its going in the dialog layout
//        builder.setView(inflater.inflate(R.layout.activity_dialog_title, null))
//
//                // Add action buttons
//                .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        // sign in the user ...
//                    }
//                })
//                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
////                        LoginDialogFragment.this.getDialog().cancel();
//                    }
//                });
//        return builder.create();
//    }
}
