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
    private Date keepWalkingDate;

    public KeepWalking() {

        this(UUID.randomUUID());
    }

    public KeepWalking(UUID uuid) {
        this.id = uuid;
        keepWalkingDate = new Date();

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

    public Date getKeepWalkingDate() {
        return keepWalkingDate;
    }

    public void setKeepWalkingDate(Date keepWalkingDate) {
        this.keepWalkingDate = keepWalkingDate;
    }


}
