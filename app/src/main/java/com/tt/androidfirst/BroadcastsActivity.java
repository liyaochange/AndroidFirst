package com.tt.androidfirst;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by liyao on 2016/6/13.
 */
public class BroadcastsActivity extends BaseActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    public static void actionStart(Context context){
        Intent intent = new Intent(context, BroadcastsActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcasts_layout);

        /*
        * IntentFilter实例，添加一个action，注册监听网络变化广播
        * */
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }


    /*
    * 内部类，创建一个广播接收器，继承BroadcastReceiver
    * */
    class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent){
            Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();
        }
    }


}
