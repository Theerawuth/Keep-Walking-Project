package com.augmentis.ayp.keep_walking;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.augmentis.ayp.keep_walking.KeepWalkingDbSchema.KeepWalkingTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Theerawuth on 8/1/2016.
 */
public class KeepWalkingCursorWrapper extends CursorWrapper {

    public KeepWalkingCursorWrapper(Cursor cursor) {

        super(cursor);
    }

    public KeepWalking getKeepWalking(){
        String uuidString = getString(getColumnIndex(KeepWalkingTable.Cols.UUID));
        String title = getString(getColumnIndex(KeepWalkingTable.Cols.TITLE));
        Long date = getLong(getColumnIndex(KeepWalkingTable.Cols.DATE));

        KeepWalking keepWalking = new KeepWalking(UUID.fromString(uuidString));
        keepWalking.setTitle(title);
        keepWalking.setKeepWalkingDate(new Date(date));

        return keepWalking;
    }

}
