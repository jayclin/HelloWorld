package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("jayclin","执行生命周期函数===FirstActivity onCreate（）===");
        setContentView(R.layout.first_layout);
        Button button1=findViewById(R.id.btn_to_second);
        Button button2=findViewById(R.id.btn_to_third);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示启动
                Intent in=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(in);
                //隐式启动
//                Intent in=new Intent("com.jayclin.action.SecondActivity");
//                startActivity(in);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(FirstActivity.this,ThirdActivity.class);
                //1、传单个数据
//                in.putExtra("test","ttt");
//                in.putExtra("num",111);
                //2、传多个数据
//                Bundle bundle=new Bundle();
//                bundle.putInt("num",100);
//                bundle.putString("test2","ttttt");
//                in.putExtras(bundle);
//                startActivity(in);
                //返回数据给FirstActivity
                startActivityForResult(in,1001);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("tag","resultCode="+resultCode);
        Log.e("tag","requestCode="+requestCode);
        Log.e("tag","data="+data.getStringExtra("back"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("jayclin","执行生命周期函数===FirstActivity onStart（）===");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("jayclin","执行生命周期函数===FirstActivity onResume（）===");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("jayclin","执行生命周期函数===FirstActivity onPause（）===");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("jayclin","执行生命周期函数===FirstActivity onStop（）===");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("jayclin","执行生命周期函数===FirstActivity onDestroy（）===");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("jayclin","执行生命周期函数===FirstActivity onRestart（）===");
    }

}
