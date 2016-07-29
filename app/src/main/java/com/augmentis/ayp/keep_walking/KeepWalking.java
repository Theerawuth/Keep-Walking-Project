package com.augmentis.ayp.keep_walking;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Theerawuth on 7/27/2016.
 */
public class KeepWalking {
    private UUID id;
    private String title;
    private Date keepwalkingDate;

    public KeepWalking() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeepWalkingDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String dateTime = format.format(new Date());
        return dateTime;
    }

    public void setKeepwalkingDate(Date keepwalkingDate) {
        this.keepwalkingDate = keepwalkingDate;
    }


}
