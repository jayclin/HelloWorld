package com.example.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private List<News> mData;
    private Context mContext;

    public NewsAdapter(List<News> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(mContext).inflate(R.layout.listview_item_layout,parent,false);
        ImageView img_icon=(ImageView)convertView.findViewById(R.id.img_icon);
        TextView title=(TextView)convertView.findViewById(R.id.tv_title);
        TextView content=(TextView)convertView.findViewById(R.id.tv_content);
        img_icon.setBackgroundResource(mData.get(position).getaIcon());
        title.setText(mData.get(position).getTitle());
        content.setText(mData.get(position).getContent());
        return convertView;
    }
}
