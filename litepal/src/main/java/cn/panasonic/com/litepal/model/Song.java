package cn.panasonic.com.litepal.model;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2016/11/8.
 */

public class Song extends DataSupport {
    @Column(nullable = false)
    private String name;
    private int duration;
    @Column(ignore = true)
    private String uselessField;
    private Album album;

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getUselessField() {
        return uselessField;
    }

    public Album getAlbum() {
        return album;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setUselessField(String uselessField) {
        this.uselessField = uselessField;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "name:"+name+",duration:"+duration+",album:"+album.toString();
    }
}
