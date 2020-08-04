package com.example.helloworld;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private List<News> mData = null;
    private Context mContext=null;
    private NewsAdapter mAdapter=null;
    private ListView listView=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        mContext=this;
        listView=(ListView) findViewById(R.id.listview);
        mData=new LinkedList<News>();
        for (int i=0;i<10;i++){
            mData.add(new News("我是一个新闻标题"+i,"我是一个新闻内容"+i,R.mipmap.ic_launcher));
        }
        mAdapter=new NewsAdapter(mData,mContext);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"点击了第"+position+"条数据",Toast.LENGTH_SHORT);
            }
        });

    }
}
