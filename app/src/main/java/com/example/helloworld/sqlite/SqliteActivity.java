package com.example.helloworld.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class SqliteActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private Button btn_insert;
    private Button btn_update;
    private Button btn_delete;
    private Button btn_select;
    private SQLiteDatabase db;
    private MyDBOpenHelper helper;
    private StringBuilder sb;
    private int i=1;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        mContext=this;
        helper=new MyDBOpenHelper(mContext,"my.db",null,2);
        bindViews();
    }

    private void bindViews() {
        btn_insert=(Button)findViewById(R.id.insert);
        btn_select=(Button)findViewById(R.id.select);
        btn_delete=(Button)findViewById(R.id.delete);
        btn_update=(Button)findViewById(R.id.update);

        btn_insert.setOnClickListener(this);
        btn_select.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        db=helper.getWritableDatabase();
        switch (v.getId()){
            case R.id.insert :
                ContentValues values=new ContentValues();
                values.put("name","hh"+i);
                i++;
                //参数依次是：表名，强制插入null值的数据列的列名，一行记录的数据
                db.insert("person",null,values);
                Toast.makeText(mContext,"插入完毕",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete :
                //参数依次是表名，以及where条件与约束
                db.delete("person","personid=?",new String[]{"3"});
                break;
            case R.id.update :
                ContentValues values1=new ContentValues();
                values1.put("name","xixi");
                //参数依次是表名，修改后的值，where条件，以及约束，如果不指定三四两个参数，会更改所有行
                db.update("person",values1,"name=?",new String[]{"hh2"});
                break;
            case R.id.select:
                sb=new StringBuilder();
                //参数依次是:表名，列名，where约束条件，where中占位符提供具体的值，指定group by的列，进一步约束
                //指定查询结果的排序方式
                Cursor cursor=db.query("person",null,null,null,null,null,null);
                if (cursor.moveToFirst()){
                    do{
                        int pid=cursor.getInt(cursor.getColumnIndex("personid"));
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        sb.append("id="+pid+"name="+name+"\n");
                    }while (cursor.moveToNext());
                }
                cursor.close();
                Toast.makeText(mContext,sb.toString(),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
