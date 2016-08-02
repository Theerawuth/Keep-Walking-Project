package com.augmentis.ayp.keep_walking;
import com.augmentis.ayp.keep_walking.KeepWalkingDbSchema.KeepWalkingTable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Theerawuth on 7/27/2016.
 */
public class KeepWalkingLab {
    private Context context;
    private SQLiteDatabase database;

    private static KeepWalkingLab instance;

    public static KeepWalkingLab getInstance(Context context){
        if (instance == null) {
            instance = new KeepWalkingLab(context);
        }
        return instance;
    }

    private static ContentValues getContentValues(KeepWalking keepWalking){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KeepWalkingTable.Cols.UUID, keepWalking.getId().toString());
        contentValues.put(KeepWalkingTable.Cols.TITLE, keepWalking.getTitle());
        contentValues.put(KeepWalkingTable.Cols.UUID, keepWalking.getId().toString());

        return contentValues;

    }

    private KeepWalkingLab(Context context){
        this.context = context.getApplicationContext();

        KeepWalkingBaseHelper keepWalkingBaseHelper = new KeepWalkingBaseHelper(context);
        database = keepWalkingBaseHelper.getWritableDatabase();

    }

    //Cursor คือ ตัวชี้ข้อมูลเพื่อจัดการกับข้อมูล
    public KeepWalkingCursorWrapper queryKeepWalking(String whereCause, String[] whereArgs){
        Cursor cursor = database.query(KeepWalkingTable.NAME,
                null,
                whereCause,
                whereArgs,
                null,
                null,
                null);

        return new KeepWalkingCursorWrapper(cursor);
    }

    public  List<KeepWalking> getKeepWalkingList() {
        List<KeepWalking> keepWalkingList = new ArrayList<>();

        KeepWalkingCursorWrapper cursorWrapper = queryKeepWalking(null, null);

        try {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                keepWalkingList.add(cursorWrapper.getKeepWalking());

                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }

        return keepWalkingList;
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

    public void addKeepWalking(KeepWalking keepWalking){
        ContentValues contentValues = getContentValues(keepWalking);
        database.insert(KeepWalkingTable.NAME, null, contentValues);
    }

//    public void deleteKeepWalking(UUID uuid){
//        database.delete(KeepWalkingTable.NAME,
//                KeepWalkingTable.Cols.UUID = " = ? ",
//                new String[] { uuid.toString() });
//    }

    public void updateKeepWalking(KeepWalking keepWalking){
        String uuidStr = keepWalking.getId().toString();
        ContentValues contentValues = getContentValues(keepWalking);

        database.update(KeepWalkingTable.NAME, contentValues,
                KeepWalkingTable.Cols.UUID + " = ? ",
                new String[] {uuidStr} );
    }




}
