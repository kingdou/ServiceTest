package com.example.administrator.servicetest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button start;
    private Button stop;
    private Button bind;
    private Button unbind;
    private Button startIntent;
    private MyService.DownloadBinder downloadBinder;
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder=(MyService.DownloadBinder)service;
            downloadBinder.getProgress();
            downloadBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.start_service);
        stop=(Button)findViewById(R.id.stop_service);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        bind=(Button)findViewById(R.id.bind_service);
        unbind=(Button)findViewById(R.id.unbind_service);
        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);
        startIntent = (Button)findViewById(R.id.intent_service);
        startIntent.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.start_service:
                Intent startIntent=new Intent(this,MyService.class);
                startService(startIntent);
                break;
            case R.id.stop_service:
                Intent stoopIntent=new Intent(this,MyService.class);
                stopService(stoopIntent);
                break;
            case R.id.bind_service:
                Intent bindIntent=new Intent(this,MyService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(connection);
                break;
            case R.id.intent_service:
                Log.d("MainActivity","Thread id is "+Thread.currentThread().getId() );
                Intent intentService = new Intent(this,MyIntentService.class);
                startService(intentService);
                break;
            default:
                break;
        }
    }
}
