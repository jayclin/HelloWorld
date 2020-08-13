package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("jayclin","执行生命周期函数===SecondActivity onCreate（）===");
        setContentView(R.layout.second_layout);
        Button button=findViewById(R.id.btn_to_first);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(SecondActivity.this,FirstActivity.class);
                startActivity(in);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("jayclin","执行生命周期函数===SecondActivity onStart（）===");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("jayclin","执行生命周期函数===SecondActivity onResume（）===");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("jayclin","执行生命周期函数===SecondActivity onPause（）===");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("jayclin","执行生命周期函数===SecondActivity onStop（）===");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("jayclin","执行生命周期函数===SecondActivity onDestroy（）===");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("jayclin","执行生命周期函数===SecondActivity onRestart（）===");
    }
}
