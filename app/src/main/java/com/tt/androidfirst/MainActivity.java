package com.tt.androidfirst;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by liyao on 2016/6/12.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //广播机制实例
        Button btn_broadcasts = (Button)findViewById(R.id.btn_broadcasts);
        btn_broadcasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BroadcastsActivity.actionStart(MainActivity.this);
            }
        });
    }

}
