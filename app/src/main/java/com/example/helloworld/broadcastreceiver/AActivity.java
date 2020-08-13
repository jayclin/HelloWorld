package com.example.helloworld.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class AActivity extends AppCompatActivity {
    private DynamicBRReceiver dynamicBRReceiver;
    private NetReceiver netReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_layout);

        //动态注册广播接收器
        dynamicBRReceiver=new DynamicBRReceiver();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("broadcastreceiver/DynamicBRReceiver");
        registerReceiver(dynamicBRReceiver,intentFilter);

        //接收系统发出的广播
        netReceiver=new NetReceiver();
        IntentFilter intentFilterNet=new IntentFilter();
        intentFilterNet.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(netReceiver,intentFilterNet);

        findViewById(R.id.btn_bd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AActivity.this,BActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicBRReceiver);
        unregisterReceiver(netReceiver);

    }

    class NetReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"NetReceiver:网络状态发生变化！！！",Toast.LENGTH_LONG).show();
        }
    }
}
