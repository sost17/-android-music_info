package com.col.commo.music;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private List<MusicInfo> musicInfos = null;
    private MusicListAdapter Listadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cursor cursor = this.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);

        listview = (ListView) findViewById(R.id.list);

        musicInfos = MusicUtil.getMp3Infos(MainActivity.this);
        Listadapter = new MusicListAdapter(this, musicInfos);
        listview.setAdapter(Listadapter);
    }
}
