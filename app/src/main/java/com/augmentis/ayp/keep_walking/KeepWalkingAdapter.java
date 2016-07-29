package com.augmentis.ayp.keep_walking;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Theerawuth on 7/28/2016.
 */
public class KeepWalkingAdapter extends RecyclerView.Adapter<KeepWalkingHolder>{

    private List<KeepWalking> _keepWalking;
    private FragmentActivity _activity;
    private static final String TAG = "TestTAG";

    public KeepWalkingAdapter(List<KeepWalking> keepWalking, FragmentActivity activity) {
        _keepWalking = keepWalking;
        _activity = activity;
        Log.d(TAG,"KeepWalking");
    }

    @Override
    public KeepWalkingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG,"KeepWalkingHolder");
        LayoutInflater layoutInflater = LayoutInflater.from(_activity);
        View v = layoutInflater.inflate(R.layout.activity_holder_keep_walkng_fragment, parent, false);
        return new KeepWalkingHolder(v, _activity);
    }

    @Override
    public void onBindViewHolder(KeepWalkingHolder holder, int position) {
            KeepWalking keepWalking = _keepWalking.get(position);
        Log.d(TAG,"onBindViewHolder ");

            holder.bindKeepWalking(keepWalking, position);
    }

    @Override
    public int getItemCount() {
        return _keepWalking.size();
    }
}
