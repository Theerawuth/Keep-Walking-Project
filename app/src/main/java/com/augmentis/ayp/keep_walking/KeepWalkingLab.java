package com.augmentis.ayp.keep_walking;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;

/**
 * Created by Theerawuth on 7/27/2016.
 */
public class KeepWalkingLab {
    static List<KeepWalking> keepWalkingList;

    private static KeepWalkingLab instance;

    public static KeepWalkingLab getInstance(){
        if (instance == null) {
            keepWalkingList = new ArrayList<>();
            instance = new KeepWalkingLab();
        }
        return instance;
    }

    private KeepWalkingLab(){

    }

    public static List<KeepWalking> getKeepWalkingList() {

        return keepWalkingList;
    }

    public KeepWalking getKeepWalkingById(UUID uuid){
        for (KeepWalking keepWalking : keepWalkingList){
            if(keepWalking.getId().equals(uuid)){
                return keepWalking;
            }
        }
        return null;
    }


}
