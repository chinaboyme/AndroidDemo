package com.littlejie.translucentbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.littlejie.demoutil.ItemInfo;
import com.littlejie.demoutil.Util;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mLv;
    private List<ItemInfo> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLv = (ListView) findViewById(R.id.lv);
        mItems = generateItems();
        mLv.setAdapter(new ArrayAdapter<ItemInfo>(this, android.R.layout.simple_list_item_1, generateItems()));
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Util.startActivity(MainActivity.this, mItems.get(position).getClz());
            }
        });
    }

    private List<ItemInfo> generateItems() {
        List<ItemInfo> items = new ArrayList<>();
        items.add(new ItemInfo("测试Toolbar", ToolbarActivity.class));
        return items;
    }
}