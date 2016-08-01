package com.augmentis.ayp.keep_walking;
import com.augmentis.ayp.keep_walking.KeepWalkingDbSchema.KeepWalkingTable;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;

/**
 * Created by Theerawuth on 7/27/2016.
 */
public class KeepWalkingLab {
    private Context context;
    private SQLiteDatabase database;

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

    //Cursor คือ ตัวชี้ข้อมูลเพื่อจัดการกับข้อมูล
    public KeepWalkingCursorWrapper queryKeepWalking(String whereCause, String[] whereArgs){
        Cursor cursor = database.query(KeepWalkingTable.NAME, null, whereCause, whereArgs, null, null, null);

        return new KeepWalkingCursorWrapper(cursor);
    }

    public  List<KeepWalking> getKeepWalkingList() {
        List<KeepWalking> keepWalkings = new ArrayList<>();

        KeepWalkingCursorWrapper cursorWrapper = queryKeepWalking(null, null);




        return keepWalkings;
    }

    public KeepWalking getKeepWalkingById(UUID uuid){
        KeepWalkingCursorWrapper cursorWrapper = queryKeepWalking( KeepWalkingTable.Cols.UUID + " = ? ",
                                                    new String[] { uuid.toString() } );
        try {
            if(cursorWrapper.getCount() == 0){
                return null;
            }

            cursorWrapper.moveToFirst();
            return cursorWrapper.getKeepWalking();
        }
        finally
        {
            cursorWrapper.close();
        }

    }


}
