package com.example.helloworld.sharedPreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class SharedPreferencesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prederences);

        final TextView tv=findViewById(R.id.tv_show);
        final EditText et=findViewById(R.id.et_input);

        findViewById(R.id.write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etStr=et.getText().toString().trim();
                SharedPreferences shp=getSharedPreferences("jayclin",MODE_PRIVATE);
                SharedPreferences.Editor editor=shp.edit();
                editor.putString("name",etStr);

                boolean isSaveSuccess=editor.commit();
                if (isSaveSuccess){
                    Toast.makeText(SharedPreferencesActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.read).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shp=getSharedPreferences("jayclin",MODE_PRIVATE);
                String s=shp.getString("name","无");
                tv.setText(s);
            }
        });
    }
}
