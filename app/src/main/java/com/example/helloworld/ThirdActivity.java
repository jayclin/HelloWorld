package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        Intent in=getIntent();
//        String val1=in.getStringExtra("test");
//        int val2=in.getIntExtra("num",0);
//        Log.e("tag","val1="+val1);
//        Log.e("tag","val2="+val2);

//        Bundle bundle=in.getExtras();
//        String val3=bundle.getString("test2");
//        int val4=bundle.getInt("num");
//        Log.e("tag","val3="+val3);
//        Log.e("tag","val4="+val4);

        Intent backIn=new Intent();
        backIn.putExtra("back","abcdef");
        setResult(1002,backIn);
    }
}
