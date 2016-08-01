package com.augmentis.ayp.keep_walking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.augmentis.ayp.keep_walking.KeepWalkingDbSchema.KeepWalkingTable;

/**
 * Created by Theerawuth on 8/1/2016.
 */
public class KeepWalkingBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;

    private static final String DATABASE_NAME = "keepwalkingBase.db";
    private static final String TAG = "KeepwalkingBaseHelper";

    public KeepWalkingBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Create Database");
        db.execSQL("CREATE table " +  KeepWalkingTable.NAME
            + "("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KeepWalkingTable.Cols.UUID + ","
                + KeepWalkingTable.Cols.TITLE + ","
                + KeepWalkingTable.Cols.DATE + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
