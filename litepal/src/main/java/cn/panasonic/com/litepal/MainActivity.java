package cn.panasonic.com.litepal;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import cn.panasonic.com.litepal.model.Album;
import cn.panasonic.com.litepal.model.Song;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getName().toString();
    Button mQueryBtn;
    TextView mShowTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db = Connector.getDatabase();

        //保存数据
        Album album = new Album();
        album.setName("album");
        album.setPrice(10.99f);
        album.save();

        Song song1 = new Song();
        song1.setName("song1");
        song1.setDuration(320);
        song1.setAlbum(album);
        song1.save();

        Song song2 = new Song();
        song2.setName("song2");
        song2.setDuration(356);
        song2.setAlbum(album);
        song2.save();

        init();
    }

    private void init()
    {
        mQueryBtn = (Button)findViewById(R.id.query);
        mShowTv = (TextView)findViewById(R.id.result);
        mQueryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Song> songs = DataSupport.where("name like ?", "song%").order("duration").find(Song.class);
                String str = new String();
                for(Song song:songs) {
                    if(song != null) {
                        str+=song.getName();
                    }
                }
                mShowTv.setText(str);
            }
        });
    }
}
