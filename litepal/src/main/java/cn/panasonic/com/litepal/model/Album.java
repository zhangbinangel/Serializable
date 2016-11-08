package cn.panasonic.com.litepal.model;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/8.
 */

public class Album extends DataSupport {
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Column(unique = true,defaultValue = "unknow")
    private String name;
    private float price;
    private List<Song> songs  = new ArrayList<>();

    @Override
    public String toString() {
        return "Album";
    }
}
